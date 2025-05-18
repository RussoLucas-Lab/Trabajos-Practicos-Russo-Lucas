import java.util.ArrayList;
import java.util.Date;

public class Principal {
    public static void main(String[] args) {

        Escuela e1 = new Escuela(1, "CUC");
        DivisionCurso d1 = new DivisionCurso(10,2025,5,e1);

        Catedra c1 = new Catedra(99, "matemáticas");
        Catedra c2 = new Catedra(98, "lengua");

        Alumno a1 = new Alumno(45105,"lucas", "Russo", new Date(1999,9,30),c1);
        Alumno a2 = new Alumno(45699,"Juan", "Garcia", new Date(1999,2,18),c1);

        //Notas de matemáticas
        Nota n1 = new Nota(9.5, new Date(125,9,25), false, a1, c1);
        Nota n2 = new Nota(7.5, new Date(125,9,25), false, a1,c1);
        Nota n3 = new Nota(6, new Date(125,9,25), false, a1,c1);
        Nota n4 = new Nota(6, new Date(125,9,25), false, a1,c1);
        Nota n5 = new Nota(6, new Date(125,9,25), false, a1,c1);

        Nota n6 = new Nota(10, new Date(125,9,25), false, a2, c1);
        Nota n7 = new Nota(10, new Date(125,9,25), false, a2,c1);
        Nota n8 = new Nota(10, new Date(125,9,25), false, a2,c1);
        Nota n9 = new Nota(10, new Date(125,9,25), false, a2,c1);
        Nota n10 = new Nota(10, new Date(125,9,25), false, a2,c1);

        //Notas de Lengua
        Nota n11 = new Nota(9.5, new Date(125,9,25), false, a1, c2);
        Nota n12 = new Nota(7.5, new Date(125,9,25), false, a1,c2);
        Nota n13 = new Nota(6, new Date(125,9,25), false, a1,c2);
        Nota n14 = new Nota(6, new Date(125,9,25), false, a1,c2);
        Nota n15 = new Nota(6, new Date(125,9,25), false, a1,c2);

        Nota n16 = new Nota(10, new Date(125,9,25), false, a2, c2);
        Nota n17 = new Nota(10, new Date(125,9,25), false, a2,c2);
        Nota n18 = new Nota(10, new Date(125,9,25), false, a2,c2);
        Nota n19 = new Nota(10, new Date(125,9,25), false, a2,c2);
        Nota n20 = new Nota(10, new Date(125,9,25), false, a2,c2);

        e1.agregarDivision(d1);

        d1.agregarCatedra(c1);
        d1.agregarCatedra(c2);

        //notas de matemática
        a1.agregarNota(n1);
        a1.agregarNota(n2);
        a1.agregarNota(n3);
        a1.agregarNota(n4);
        a1.agregarNota(n5);


        a2.agregarNota(n6);
        a2.agregarNota(n7);
        a2.agregarNota(n8);
        a2.agregarNota(n9);
        a2.agregarNota(n10);

        c1.agregarAlumno(a1);
        c1.agregarAlumno(a2);

        c1.agregarNota(n1);
        c1.agregarNota(n2);
        c1.agregarNota(n3);
        c1.agregarNota(n4);
        c1.agregarNota(n5);
        c1.agregarNota(n6);
        c1.agregarNota(n7);
        c1.agregarNota(n8);
        c1.agregarNota(n9);
        c1.agregarNota(n10);

        //notas de lengua
        a1.agregarNota(n11);
        a1.agregarNota(n12);
        a1.agregarNota(n13);
        a1.agregarNota(n14);
        a1.agregarNota(n15);


        a2.agregarNota(n16);
        a2.agregarNota(n17);
        a2.agregarNota(n18);
        a2.agregarNota(n19);
        a2.agregarNota(n20);

        c2.agregarAlumno(a1);
        c2.agregarAlumno(a2);

        c2.agregarNota(n11);
        c2.agregarNota(n12);
        c2.agregarNota(n13);
        c2.agregarNota(n14);
        c2.agregarNota(n15);
        c2.agregarNota(n16);
        c2.agregarNota(n17);
        c2.agregarNota(n18);
        c2.agregarNota(n19);
        c2.agregarNota(n20);
        
        //System.out.println(d1.mejorAlumnoDivisionCurso().getKey().getNombre() + " " +d1.mejorAlumnoDivisionCurso().getValue() );
        //System.out.println(e1.getMejorAlumnoEscuela(1999).getNombre());

        System.out.println(e1.getMejoresAlumnos(1999));
        for (Alumno alumno : e1.getMejoresAlumnos(1999) ){
            System.out.println(alumno.getNombre());
        }

    }
}
