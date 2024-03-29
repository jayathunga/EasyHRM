import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { CustomerComponent } from './customer/customer.component';
import { TaskComponent } from './task/task.component';
import { EmployeeComponent } from './employee/employee.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProductsComponent } from './products/products.component';
import { UserComponent } from './user/user.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import {MatDialogModule} from '@angular/material/dialog'; 
import {MatButtonModule} from '@angular/material/button';

@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    ContactComponent,
    HomeComponent,
    CustomerComponent,
    TaskComponent,
    EmployeeComponent,
    ProductsComponent,
    UserComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatSnackBarModule,
    MatDialogModule, 
    MatButtonModule 
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
