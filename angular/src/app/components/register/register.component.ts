import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators , ReactiveFormsModule } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  imports: [ReactiveFormsModule,RouterModule,CommonModule],
})
export class RegisterComponent {
  registerForm: FormGroup;
  isSuccess: boolean | null = null;  // Variable para controlar el estado de éxito o error
  errorMessage: string = '';         // Mensaje de error en caso de fallo

  constructor(private fb: FormBuilder, private userService: UserService) {
    this.registerForm = this.fb.group({
      nickname: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }

  onSubmit(): void {
    if (this.registerForm.valid) {
      this.userService.register(this.registerForm.value).subscribe(response => {
        console.log('Registration successful', response);
        this.isSuccess = true;  // El registro fue exitoso
        this.errorMessage = '';  // Limpiar cualquier mensaje de error
      }, error => {
        console.error('Registration failed', error);
        this.isSuccess = false; // El registro falló
        this.errorMessage = 'Registration failed. Please try again.';  // Mensaje de error
      });
    }
  }
}
