import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { RouterModule, Routes } from "@angular/router";
import { AppComponent } from "./app.component";
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';

const routes:Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutComponent },

  { path: 'user', loadChildren: ()=>import("./modules/user/user.module").then(module=>module.UserModule) },

  // { path: '**', component: NotFoundComponent }
  { path: '**', redirectTo: 'home' }
]

@NgModule({
  declarations: [AppComponent, HeaderComponent, HomeComponent, AboutComponent], // comp, direct, pipe
  imports: [BrowserModule, RouterModule.forRoot(routes)], // other modules (app)
  bootstrap: [AppComponent]
})
export class AppModule{}

