// export class Book{
//     title:string = "";
//     author:string = "";
//     price:number = 0

//     constructor(title:string, author:string, price:number){
//         this.title = title;
//         this.author = author;
//         this.price = price;
//     }

// }


export class Book{
 
    constructor(
        public title:string, 
        public author:string, 
        public price:number
    ){}

}