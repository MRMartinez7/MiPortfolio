import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-editaboutme',
  templateUrl: './editaboutme.component.html',
  styleUrls: ['./editaboutme.component.css']
})
export class EditaboutmeComponent implements OnInit {
  persona: Persona = null;

  constructor(private activatedRouter: ActivatedRoute,
    private personaService: PersonaService, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.personaService.detail(id).subscribe(
      data=> {
        this.persona=data;
      }, err => {
        alert("error al modificar");
        this.router.navigate(['']);
      }
    )
  }
  
  onUpdate(){const id = this.activatedRouter.snapshot.params['id'];
  this.personaService.update(id, this.persona).subscribe(
    data=>{
      this.router.navigate(['']);
    }, err =>{
      alert("Error al modificar persona");
      this.router.navigate(['']);
    }
  )

  }
  uploadImage($event:any){

  }

}
