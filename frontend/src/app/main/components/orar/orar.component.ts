import {Component, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {OrarService} from "../../services/orar.service";
import {ConfirmationComponent} from "../../../common/components/form/confirmation/confirmation.component";
import {AddOrarComponent} from "./add-orar/add-orar.component";

@Component({
  selector: 'ip-orar',
  templateUrl: './orar.component.html',
  styleUrls: ['./orar.component.css']
})
export class OrarComponent implements OnInit {
  @ViewChild(ConfirmationComponent)
  modalConfirm: ConfirmationComponent;
  @ViewChild(AddOrarComponent)
  modalAdd: AddOrarComponent;
  role = sessionStorage.getItem("role");

  private orar: any;
  private deleteId: number;
  private disciplina: any;
  private numeDisciplina: string;

  constructor(private orarService: OrarService, public router: Router) { }

  ngOnInit() {
    this.getOrar();
  }

  private getOrar() {
    this.orarService.getList().subscribe((response) => {
      this.orar = response;
    });
  }

  orarDelete(id) {
    this.deleteId = id;
  }

  handleDelete(confirm) {
    if (confirm == true) {
      this.orarService.deleteObject("api/v1/orar/crud/delete", this.deleteId).subscribe(
        (succes) => {
          console.log("sters");
          this.getOrar();
        },
        (error) => {
          console.log("nesters");
        },
        () => {
        }
      );
    }
  }

  handleAdd(confirm) {
    if(confirm == true)
      this.getOrar();
  }


}
