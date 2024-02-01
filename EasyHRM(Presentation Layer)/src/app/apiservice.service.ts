import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiserviceService {

  constructor(private http: HttpClient) { }

  //customer API requests
  getCustomersData(): Observable<any> {
    return this.http.get(environment.baseURL + '/customers');
  }

  saveCustomerData(body: any): Observable<any> {
    return this.http.post(environment.baseURL + '/customer', body);

  }

  deleteCustomerData(customerid: any): Observable<any> {
    return this.http.delete(environment.baseURL + '/customerDelete/' + customerid)

  }

  updateCustomerData(customerid: any, body: any): Observable<any> {
    return this.http.put(environment.baseURL + '/customerUpdate/' + customerid, body);

  }

  getCustomerData(customerid: any): Observable<any> {
    return this.http.get(environment.baseURL + '/customer/' + customerid);

  }

  //Employee API requests
  getEmployeeData(): Observable<any> {
    return this.http.get(environment.baseURL + '/employee/getAll');

  }

  saveEmployeeData(body: any): Observable<any> {
    return this.http.post(environment.baseURL + '/employee/create', body);

  }

  deleteEmployee(employeeId: any): Observable<any> {
    return this.http.delete(environment.baseURL + '/employee/deleteEmployee/' + employeeId);

  }

  getEmployeeDataById(employeeId: any): Observable<any> {
    return this.http.get(environment.baseURL + '/employee/getoneEmployee/' + employeeId);

  }

  updateEmployeeData(employeeId: any, body: any): Observable<any> {
    return this.http.put(environment.baseURL + '/employee/updateEmployee/' + employeeId, body);

  }

  //Task API requests
  getTasksData(): Observable<any> {
    return this.http.get(environment.baseURL + '/task/getAll');
  }

  getCustomerDropDownData(): Observable<any> {
    return this.http.get(environment.baseURL + '/customers');

  }
  saveTaskData(body: any): Observable<any> {
    return this.http.post(environment.baseURL + '/task/create', body);

  }

  completeTaskData(itemId: any, body: any): Observable<any> {
    return this.http.put(environment.baseURL + '/task/update/' + itemId, body);
  }

  getTaskDataById(itemId: any): Observable<any> {
    return this.http.get(environment.baseURL + '/task/getOneById/' + itemId);

  }

  deleteTaskData(itemId: any): Observable<any> {
    return this.http.delete(environment.baseURL + '/task/delete/' + itemId);

  }

  //products API requests
  getProductData(): Observable<any> {
    return this.http.get(environment.subURL + '/products/getAllData');

  }
  saveProductData(body: any): Observable<any> {
    return this.http.post(environment.subURL + '/products/saveData', body);
  }

  getUserData(): Observable<any> {
    return this.http.get(environment.subURL + '/user/getUserData');
  }


  //Easy HRM EndPoints Urls

  createDepartment(object:any):Observable<any>{
    return this.http.post('http://localhost:8080/api/v1/test/create',object);
  }

  getAllDepartments():Observable<any>{
      return this.http.get('http://localhost:8080/api/v1/test/getAllTest');
  }

  getOneDepartment(id:any):Observable<any>{
    return this.http.get('http://localhost:8080/api/v1/test/getOne/'+id);
  }

  updateDepartment(object:any,id:any):Observable<any>{
     return this.http.put('http://localhost:8080/api/v1/test/updateTest/'+id,object);
  }

  createEmployee(object:any):Observable<any>{
    return this.http.post('http://localhost:8080/api/v1/emp/create',object);
  }

  getAllEmployee():Observable<any>{
    return this.http.get('http://localhost:8080/api/v1/emp/getAllEmployee');
  }

  getOneEmployee(id:any):Observable<any>{
    return this.http.get('http://localhost:8080/api/v1/emp/getOne/'+id);
  }

  updateEmployee(object:any,id:any):Observable<any>{
    return this.http.put('http://localhost:8080/api/v1/emp/updateEmp/'+id,object);
  }

  deleteUser(id:any):Observable<any>{
   return this.http.delete('http://localhost:8080/api/v1/emp/delete/'+id);
  }

  createLeave(object:any):Observable<any>{
    return this.http.post('http://localhost:8080/api/v1/leave/create/',object);
  }

  getAllLeaves():Observable<any>{
    return this.http.get('http://localhost:8080/api/v1/leave/getAllLeaves');
  }

  getOneLeave(id:any):Observable<any>{
    return this.http.get('http://localhost:8080/api/v1/leave/getOne/'+id);
  }

  updateLeave(object:any,id:any):Observable<any>{
    return this.http.put('http://localhost:8080/api/v1/leave/updateLeave/'+id,object);
  }
}
