import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FiltroPesquisaComponent } from './filtro-pesquisa.component';

describe('FiltroPesquisaComponent', () => {
  let component: FiltroPesquisaComponent;
  let fixture: ComponentFixture<FiltroPesquisaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FiltroPesquisaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FiltroPesquisaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
