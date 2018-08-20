import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { NavegacaoComponent } from './header/navegacao/navegacao.component';
import { AutenticacaoComponent } from './header/autenticacao/autenticacao.component';
import { FiltroComponent } from './filtro/filtro.component';
import { FiltroPesquisaComponent } from './filtro/filtro-pesquisa/filtro-pesquisa.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavegacaoComponent,
    AutenticacaoComponent,
    FiltroComponent,
    FiltroPesquisaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
