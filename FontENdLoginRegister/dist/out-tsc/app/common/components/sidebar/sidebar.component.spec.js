import { async, TestBed } from '@angular/core/testing';
import { SidebarComponent } from './sidebar.component';
describe('SidebarComponent', function () {
    var component;
    var fixture;
    beforeEach(async(function () {
        TestBed.configureTestingModule({
            declarations: [SidebarComponent]
        })
            .compileComponents();
    }));
    beforeEach(function () {
        fixture = TestBed.createComponent(SidebarComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', function () {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=C:/Users/Andra/Desktop/Git/Proiect-IP/FontENdLoginRegister/src/app/common/components/sidebar/sidebar.component.spec.js.map