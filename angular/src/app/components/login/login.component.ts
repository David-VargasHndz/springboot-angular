import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators , ReactiveFormsModule } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  imports: [ReactiveFormsModule,RouterModule,CommonModule],
})
export class LoginComponent {
  loginForm: FormGroup;
  isSuccess: boolean | null = null;  // Variable para controlar el estado de éxito o error
  errorMessage: string = '';         // Mensaje de error en caso de fallo

  constructor(private fb: FormBuilder, private userService: UserService, private router: Router) {
      this.loginForm = this.fb.group({
        nickname: ['', Validators.required],
        password: ['', Validators.required],
      });
    }

    onSubmit(): void {
      if (this.loginForm.valid) {
        this.userService.login(
          this.loginForm.value.nickname,
          this.loginForm.value.password
        ).subscribe(response => {
          this.userService.setUser(response);
          this.isSuccess = true;  // El inicio de sesión fue exitoso
          this.errorMessage = '';  // Limpiar cualquier mensaje de error
          this.router.navigate(['/dashboard']);
        }, error => {
          this.isSuccess = false; // El inicio de sesión falló
          this.errorMessage = 'Login failed. Please check your credentials and try again.';  // Mensaje de error
        });
      }
    }
  }
