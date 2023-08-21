import { TestBed } from '@angular/core/testing';
import { ResolveFn } from '@angular/router';

import { empresaResolver } from './empresa.resolver';

describe('empresaResolver', () => {
  const executeResolver: ResolveFn<boolean> = (...resolverParameters) => 
      TestBed.runInInjectionContext(() => empresaResolver(...resolverParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeResolver).toBeTruthy();
  });
});
