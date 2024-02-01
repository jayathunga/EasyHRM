import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ApiserviceService } from '../apiservice.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialog } from '@angular/material/dialog';



@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit {
  leaveData:any[]=[];
  leaveId:any;
  show:boolean=false;


  form = new FormGroup({
    date: new FormControl('', Validators.required),
    days: new FormControl('', Validators.required),
    type: new FormControl('', Validators.required),
  });

  constructor(private http: HttpClient, public service: ApiserviceService,private snackBar: MatSnackBar,private dialog:MatDialog) { }

  ngOnInit(): void {
    this.getAllLeaves();
  }

  saveLeave(){
    this.service.createLeave({
      date: this.form.get('date')?.value,
      leaveCount:this.form.get('days')?.value,
      leaveType:this.form.get('type')?.value
    }).subscribe((data)=>{
      console.log('saved successfully');
      this.snackBar.open("Saved successfully","X",{"duration": 2000});
      this.getAllLeaves();
    });
  }

  getAllLeaves(){
    this.service.getAllLeaves().subscribe((data)=>{
      console.log(data);
      this.leaveData=data.leaveDtoList;
    });
  }

  Edit(id:any){
    this.show=true;
    this.service.getOneLeave(id).subscribe((data)=>{
      this.form.patchValue({
        date:data.date,
        days:data.leaveCount,
        type:data.leaveType,
      });
      console.log("Data"+data);
      this.leaveData[0]=data;
      this.leaveId=this.leaveData[0].id;
    });
  }
  close(){
    this.show=false;
  }

  updateData(){
    this.service.updateLeave({
      date:this.form.get('date')?.value,
      leaveCount:this.form.get('days')?.value,
      leaveType:this.form.get('type')?.value
    },this.leaveId).subscribe((data)=>{
      console.log("Leave Data updated successfully");
      this.snackBar.open("Leave Updated successfully","X",{"duration": 2000});
      this.getAllLeaves();
    });
  }

  






}
