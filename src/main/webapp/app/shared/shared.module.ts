import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { DeclAutreTaxeSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [DeclAutreTaxeSharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [DeclAutreTaxeSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DeclAutreTaxeSharedModule {
  static forRoot() {
    return {
      ngModule: DeclAutreTaxeSharedModule
    };
  }
}
