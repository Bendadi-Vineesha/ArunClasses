import { Component } from "@angular/core";
import { MovieService } from "./movie.service";

@Component({
    selector: "app-root",
    templateUrl: `app.component.html`,
    styleUrls: ['app.component.scss']
})
export class AppComponent { 

    movies:any[] = [];

    constructor(private movieService:MovieService){}

    ngOnInit(){
        this.findAllMovies();
    }

    findAllMovies(){
        this.movieService.findAll()
        .subscribe({
            next: (res:any)=>{
                console.log(res);
                this.movies = res;
            },
            error: (err:any)=>{
                console.log(err)
            }
        })
    }

    deleteMovie(id:number){
        this.movieService.delete(id)
        .subscribe({
            next: (res:any)=>{
                console.log("Delete is success")
                console.log(res);
                this.findAllMovies();
            },
            error: (err:any)=>{
                console.log("Delete failed")
                console.log(err)
            }
        })
    }
    

    create(){
        let movie = {title: "Antman", ratings: 4.2, director: "Arun"};

        this.movieService.createMovie(movie)
        .subscribe({
            next: (res:any)=>{
                console.log("create is success")
                console.log(res);
                this.findAllMovies();
            },
            error: (err:any)=>{
                console.log("create failed")
                console.log(err)
            }
        })
    }
}