import {Component, OnInit, ViewChild, EventEmitter, Output} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/components/modal";
import {Coursetype} from "../../../interfaces/Coursetype";
import {Checkin} from "../../../interfaces/Checkin";
import {CheckinService} from "../../../services/checkin.service";

@Component({
  selector: 'ip-addcheckin',
  templateUrl: './addcheckin.component.html',
  styleUrls: ['./addcheckin.component.css']
})
export class AddcheckinComponent implements OnInit {

  @ViewChild(ModalComponent)
  modalAdd: ModalComponent;
  @Output() submittedCheckin = new EventEmitter();

  checkin: Checkin = new Checkin;

  constructor(private checkinService: CheckinService) { }

  ngOnInit() {
    this.checkin.userId = sessionStorage.getItem("userId");
  }

  open() {
    this.modalAdd.open();
  }

  close() {
    this.modalAdd.close();
  }

  addCheckin() {
    this.checkinService.addCheckin(this.checkin).subscribe(
      (succes) => {
        this.submittedCheckin.emit(true);
        this.modalAdd.close();
      }
    )
  }

}
