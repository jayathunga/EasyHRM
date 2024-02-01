import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { ApiserviceService } from '../apiservice.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss'],
})
export class CustomerComponent implements OnInit {
  departmentData:any[]=[];
  show:boolean=false;
  departmentId:any;

  form = new FormGroup({
    name: new FormControl('', Validators.required),
    department: new FormControl('', Validators.required),
  });

  constructor(public service: ApiserviceService,private snackBar: MatSnackBar,private dialog:MatDialog) {}

  ngOnInit(): void {
    this.getAllDepartments();
  }
  objectData = {
    name: this.form.get('name')?.value,
    address: this.form.get('department')?.value,
  };

  saveUser() {
    console.log('Data ' + this.form.get.name);
    this.service
      .createDepartment({
        name: this.form.get('name')?.value,
        address: this.form.get('department')?.value,
      })
      .subscribe((data) => {
        console.log('saved successfully');
        this.snackBar.open("Saved successfully","X",{"duration": 2000});
        this.getAllDepartments();
      });
  }

  getAllDepartments(){
    this.service.getAllDepartments().subscribe((data)=>{
      console.log(data);
      this.departmentData=data.testDomainList;
    });
  }

  Edit(id:any){
    this.show=true;
    this.service.getOneDepartment(id).subscribe((data)=>{
      this.form.patchValue({
        name:data.name,
        department:data.address
      });
      console.log("Data"+data);
      this.departmentData[0]=data;
      this.departmentId=this.departmentData[0].id;
    });
  }

  close(){
    this.show=false;
  }

  updateData(){
    this.service.updateDepartment({
      name:this.form.get('name')?.value,
      department:this.form.get('department')?.value
    },this.departmentId).subscribe((data)=>{
      console.log("Department Data updated successfully");
      this.snackBar.open("Data Updated successfully","X",{"duration": 2000});
      this.getAllDepartments();
    });
  }

  
}
