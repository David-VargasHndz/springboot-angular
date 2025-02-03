import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private apiUrl = 'http://localhost:8080/api/users';
  private storageKey = 'user';

  constructor(private http: HttpClient) {}

  login(nickname: string, password: string): Observable<any> {
    const params = new HttpParams()
          .set('nickname', nickname)
          .set('password', password);
    return this.http.get(`${this.apiUrl}`, { params });
  }

  register(user: any): Observable<any> {
    return this.http.post(`${this.apiUrl}`, {
        nickname: user.nickname,
        password: user.password
      });
  }

   // Método para verificar si el usuario está logeado
    isLoggedIn(): boolean {
      const user = localStorage.getItem(this.storageKey);
      return user !== null; // Si hay un usuario guardado en localStorage, está logeado
    }

    // Método para obtener el nombre de usuario del usuario logeado
    getUsername(): string | null {
      const user = localStorage.getItem(this.storageKey);
      return user ? JSON.parse(user).nickname : null; // Devuelve el nombre de usuario si está logeado
    }

    // Método para guardar el usuario en localStorage (cuando se logea correctamente)
    setUser(user: any): void {
      localStorage.setItem(this.storageKey, JSON.stringify(user));
    }

    // Método para cerrar sesión
    logout(): void {
      localStorage.removeItem(this.storageKey); // Elimina el usuario del localStorage
    }
}
