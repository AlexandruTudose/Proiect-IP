import {Component, OnInit, ViewChild, Output, EventEmitter} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/components/modal";

@Component({
  selector: 'ip-confirm',
  templateUrl: './confirmation.component.html',
  styleUrls: ['./confirmation.component.css']
})
export class ConfirmationComponent implements OnInit {
  @ViewChild(ModalComponent)
  modalConfirm: ModalComponent;
  @Output() pageChanged = new EventEmitter();
  productid: any;

  constructor() {
  }

  open(productid) {
    this.productid = productid;
    this.modalConfirm.open();
  }

  confirmDelete() {
    this.pageChanged.emit(true);
    this.modalConfirm.close();
  }

  disagree(){
    this.pageChanged.emit(false);
    this.modalConfirm.close();
  }

  ngOnInit() {
  }
}
