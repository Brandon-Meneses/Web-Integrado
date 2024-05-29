import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  showLoginForm = false;

  toggleLoginForm() {
    this.showLoginForm = !this.showLoginForm;
  }
}