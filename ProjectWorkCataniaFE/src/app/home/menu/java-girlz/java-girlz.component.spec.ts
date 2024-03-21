import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JavaGirlzComponent } from './java-girlz.component';

describe('JavaGirlzComponent', () => {
  let component: JavaGirlzComponent;
  let fixture: ComponentFixture<JavaGirlzComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [JavaGirlzComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(JavaGirlzComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
