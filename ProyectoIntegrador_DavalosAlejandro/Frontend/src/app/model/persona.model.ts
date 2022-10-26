export class Persona{
    id?: Number;
    nombre!: string;
    apellido!: string;
    titulo!: string;
    about!: string;
    img!: string;

    constructor(nombre: string, apellido: string, titulo: string, about: string, img: string){
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.about = about;
        this.img = img;
    }

}