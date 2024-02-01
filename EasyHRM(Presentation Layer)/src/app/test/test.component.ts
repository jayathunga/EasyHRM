import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ApiserviceService } from '../apiservice.service';
import { HttpParams } from '@angular/common/http';

export interface Test {
  id: String;
  name: String;
  address: String;
  position: String;
  salary: Number;
  age: Number;
}
@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss'],
})
export class TestComponent implements OnInit {
  testObject: any = {};
  testObj: any = {};
  test: Test[] = [];
  name: any;
  address: any;
  position: any;
  salary: any;
  age: any;

  form = new FormGroup({
    name: new FormControl('', Validators.required),
    adress: new FormControl('', Validators.required),
    position: new FormControl('', Validators.required),
    salary: new FormControl('', Validators.required),
    age: new FormControl('', Validators.required),
  });
  constructor(public service: ApiserviceService) {}

  ngOnInit(): void {
    this.getTestData();
  }

  saveTestData() {
    let body = new HttpParams({
      fromObject: {
        name: this.name,
        address: this.address,
        position: this.position,
        salary: this.salary,
        age: this.age,
      },
    });

    //console.log("Test Data"+body)
    this.service.createTestData(body).subscribe((response) => {
      alert('saved successfully');
    });
  }

  getTestData() {
    this.service.getAllTestData().subscribe((data) => {
      this.test = data;
    });
    console.log(this.test);
  }

  getOneData(objectid: any) {
    this.service.getOneTestObject(objectid).subscribe((data) => {
      this.testObject = data;
    });
  }

  updateTestData(){
    this.service.updateTestData(this.testObj.id,this.testObject).subscribe((date)=>{
     alert("success");
     this.getTestData();
    });
  }

  deleteTestData(id:any){
this.service.deleteTestData(id).subscribe((data)=>{
  alert("Delete sucessfully!");
this.getTestData();
});
  }
}
