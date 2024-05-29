import { Component } from '@angular/core';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent {
  email: string = '';
  password: string = '';

  constructor() { }

  onSubmit() {
    // Aquí puedes agregar la lógica para manejar la autenticación
    console.log('Email:', this.email);
    console.log('Password:', this.password);
  }
}