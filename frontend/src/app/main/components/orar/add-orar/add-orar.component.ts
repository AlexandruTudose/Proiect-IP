import {Component, OnInit, Output, ViewChild} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {OrarService} from "../../../services/orar.service";
import {Router} from "@angular/router";
import {EventEmitter} from "@angular/common/src/facade/async";
import {Orar} from "../../../interfaces/Orar";

@Component({
  selector: 'ip-add-orar',
  templateUrl: './add-orar.component.html',
  styleUrls: ['./add-orar.component.css']
})
export class AddOrarComponent implements OnInit {
  @ViewChild(ModalComponent)
  modalMember: ModalComponent;

  private err: boolean;
  private ora: Orar = new Orar();
  @Output() pageChanged = new EventEmitter();

  constructor(private orarService: OrarService, public router: Router) {
    this.orarService = orarService;
    this.router = router;
  }

  ngOnInit() {
  }

  open() {
    this.err = false;
    this.modalMember.open();
  }

  close() {
    this.modalMember.close();
  }

  addObject() {
    this.addMember();
  }

  addMember() {
    this.orarService.updateObject("api/v1/orar/crud/create", this.ora).subscribe(
      (succes) => {
        this.modalMember.close();
        this.pageChanged.emit(true);
      },
      (error) => {
        this.err = true;
      },
      () => {
      }
    );
  }

}
