import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
  imports: [CommonModule,RouterModule],
})
export class DashboardComponent implements OnInit {
   username: string | null = null; // Nombre del usuario
  isLoggedIn: boolean = false; // Estado de si el usuario está logeado

  constructor(private userService: UserService,  private router: Router) {}

  ngOnInit(): void {
    // Verificamos si el usuario está logeado y obtenemos su nombre
    this.isLoggedIn = this.userService.isLoggedIn();
    if (this.isLoggedIn) {
      this.username = this.userService.getUsername();
    }
  }

  logout(): void {
    this.userService.logout(); // Llamar a un método de logout
    this.isLoggedIn = false;
    this.username = '';
    this.router.navigate(['/login']);
  }
}
