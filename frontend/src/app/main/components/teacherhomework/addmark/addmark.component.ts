import {Component, OnInit, ViewChild, Output, EventEmitter} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/components/modal";
import {HomeworksService} from "../../../services/homeworks.service";
import {Mark} from "../../../interfaces/Mark";

@Component({
  selector: 'ip-addmark',
  templateUrl: './addmark.component.html',
  styleUrls: ['./addmark.component.css']
})
export class AddmarkComponent implements OnInit {

  @ViewChild(ModalComponent)
  modalAddMark: ModalComponent;
  @Output() pageChanged = new EventEmitter();

  markID: number;
  mark: Mark = new Mark();

  constructor(private homeworksService: HomeworksService) {
  }

  ngOnInit() {
  }

  open(id) {
    this.markID = id;
    this.getMark(this.markID);
    this.modalAddMark.open();
    this.mark.id_profesor = 1;
  }

  close() {
    this.modalAddMark.close();
  }

  getMark(id) {
    this.homeworksService.getMark(this.markID).subscribe((response) => {
      this.mark = response;
    })
  }

  updateMark() {
    this.homeworksService.updateMark(this.markID,this.mark).subscribe(
      (succes) => {
        this.pageChanged.emit(true);
        this.modalAddMark.close();
      }
    )
  }

}
