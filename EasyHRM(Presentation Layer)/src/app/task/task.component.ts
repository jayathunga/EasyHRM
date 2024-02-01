import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ApiserviceService } from '../apiservice.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialog } from '@angular/material/dialog';



@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.scss']
})
export class TaskComponent implements OnInit {
 
  employeeData:any[]=[];
  show:boolean=false;
  pop:boolean=false;
  employeeId:any;

  form = new FormGroup({
    name: new FormControl('', Validators.required),
    position: new FormControl('', Validators.required),
    address: new FormControl('', Validators.required),
    age: new FormControl('', Validators.required),
    salary: new FormControl('', Validators.required),
  });

  constructor(private http: HttpClient, public service: ApiserviceService,private snackBar: MatSnackBar,private dialog:MatDialog) { }

  ngOnInit(): void {
    this.getAllEmployeeData();
  }

  saveEmployee(){
    console.log('Data ' + this.form);
     this.service.createEmployee({
      name: this.form.get('name')?.value,
      position: this.form.get('position')?.value,
      address: this.form.get('address')?.value,
      age: this.form.get('age')?.value,
      salary: this.form.get('salary')?.value,
     }).subscribe((data)=>{
      this.snackBar.open("Saved successfully","X",{"duration": 2000});
      this.getAllEmployeeData();
     });
  }

  Edit(id:any){
    this.show=true;
    this.service.getOneEmployee(id).subscribe((data)=>{
      this.form.patchValue({
        name:data.name,
        position:data.position,
        address:data.address,
        age:data.age,
        salary:data.salary
      });
      console.log("Data"+data);
      this.employeeData[0]=data;
      this.employeeId=this.employeeData[0].id;
    });
  }

  getAllEmployeeData(){
    this.service.getAllEmployee().subscribe((data)=>{
      this.employeeData=data.employeeDtoList;
      console.log(data+"employees");
    });
  }

  updateData(){
    this.service.updateEmployee({
      name:this.form.get('name')?.value,
      position:this.form.get('position')?.value,
      address:this.form.get('address')?.value,
      age:this.form.get('age')?.value,
      salary:this.form.get('salary')?.value
    },this.employeeId).subscribe((data)=>{
      console.log("Department Data updated successfully");
      this.snackBar.open("Data Updated successfully","X",{"duration": 2000});
      this.getAllEmployeeData();
    });
  }

  close(){
    this.show=false;
  }


  delete(id:any){
    this.service.deleteUser(id).subscribe((data)=>{
      this.snackBar.open("Data Delete successfully","X",{"duration": 2000});
      this.getAllEmployeeData();
    });
  }


}
