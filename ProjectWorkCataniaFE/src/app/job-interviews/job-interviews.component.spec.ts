import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobInterviewsComponent } from './job-interviews.component';

describe('JobInterviewsComponent', () => {
  let component: JobInterviewsComponent;
  let fixture: ComponentFixture<JobInterviewsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [JobInterviewsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(JobInterviewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
