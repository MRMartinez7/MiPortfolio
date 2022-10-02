import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LogosComponent } from './components/logos/logos.component';
import { SocialComponent } from './components/social/social.component';
import { HeaderComponent } from './components/header/header.component';
import { BannerComponent } from './components/banner/banner.component';
import { AboutmeComponent } from './components/aboutme/aboutme.component';
import { ExperienciaComponent } from './components/experiencia/experiencia.component';
import { EstudiosComponent } from './components/estudios/estudios.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { SkillsComponent } from './components/skills/skills.component';
import { ProyectoComponent } from './components/proyecto/proyecto.component';
import { FooterComponent } from './components/footer/footer.component';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    LogosComponent,
    SocialComponent,
    HeaderComponent,
    BannerComponent,
    AboutmeComponent,
    ExperienciaComponent,
    EstudiosComponent,
    SkillsComponent,
    ProyectoComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgCircleProgressModule.forRoot({}),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
