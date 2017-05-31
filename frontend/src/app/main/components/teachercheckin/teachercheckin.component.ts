import {Component, OnInit, ViewChild} from '@angular/core';
import {Checkin} from "../../interfaces/Checkin";
import {CheckinService} from "../../services/checkin.service";
import {AddcheckinComponent} from "./addcheckin/addcheckin.component";

@Component({
  selector: 'ip-teachercheckin',
  templateUrl: './teachercheckin.component.html',
  styleUrls: ['./teachercheckin.component.css']
})
export class TeachercheckinComponent implements OnInit {

  @ViewChild(AddcheckinComponent)
  modalAdd: AddcheckinComponent;

  checks: any;

  constructor(private checkinService: CheckinService) { }

  ngOnInit() {
    this.getCheckins();
  }

  getCheckins() {
    this.checkinService.getList().subscribe(
      (response) => {
        this.checks = response;
      }
    )
  }

  submittedCheckin(confirmation) {
    if(confirmation)
      this.getCheckins();
  }

}
