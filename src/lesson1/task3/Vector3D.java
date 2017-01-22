package lesson1.task3;

import java.util.Arrays;

/**
 * Created by artem on 18.01.17.
 */


public class Vector3D {
    private double[] start;
    private double[] end;
    private double[] vector=new double[3];

    public Vector3D() {}

    public Vector3D(double[] start, double[] end) {
        setStart(start);
        setEnd(end);
        calculateVector();
    }

    public double[] getVector() {
        return vector;
    }

    private void calculateVector() {
        if(this.start != null && this.end != null) {
            for(int i=0; i<3; i++) {
                this.vector[i] = this.end[i] - this.start[i];
            }
        }
    }

    public double[] getStart() {
        return start;
    }

    public void setStart(double[] start) {
        if(start == null || start.length != 3) {
            System.out.println(String.format("Three coordinates required! Got: %s", Arrays.toString(start)));
            System.exit(1);
        } else {
            this.start = start;
            calculateVector();
        }
    }

    public double[] getEnd() {
        return end;
    }

    public void setEnd(double[] end) {
        if(end == null || end.length != 3) {
            System.out.println(String.format("Three coordinates required! Got: %s", Arrays.toString(end)));
            System.exit(1);
        } else {
            this.end = end;
            calculateVector();
        }
    }

    public Vector3D add(Vector3D otherVector) {
        Vector3D result = null;
        if(Arrays.equals(this.start, otherVector.end)) {
            result = new Vector3D(otherVector.start, this.end);
        }
        else if(Arrays.equals(this.end, otherVector.start)) {
            result =  new Vector3D(this.start, otherVector.end);
        } else {
            System.out.println(String.format("Vectors: (%s; %s) and (%s; %s) can't be added!", Arrays.toString(this.start),
                    Arrays.toString(this.end), Arrays.toString(otherVector.start), Arrays.toString(otherVector.end)));
        }
        return result;
    }

    public double scalarProd(Vector3D otherVector) {
        double scalarProd = 0;
        for(int i=0; i<3; i++) {
            scalarProd += (this.vector[i]) * (otherVector.vector[i]);
        }
        return scalarProd;
    }

    public double[] vectorProd(Vector3D otherVector) {
        double[] vectorProd = new double[3];
        for(int i=0; i<3; i++) {
            vectorProd[i] = this.vector[(i + 1) % 3] * otherVector.vector[(i + 2) % 3] - this.vector[(i + 2) % 3] * otherVector.vector[(i + 1) % 3];
        }
        return vectorProd;
    }

    @Override
    public String toString() {
        return "Vector3D{" +
                "start=" + Arrays.toString(start) +
                ", end=" + Arrays.toString(end) +
                ", vector=" + Arrays.toString(vector) +
                '}';
    }
}
