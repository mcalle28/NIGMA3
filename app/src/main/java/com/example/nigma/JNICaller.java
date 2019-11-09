package com.example.nigma;

public class JNICaller {
    public static native void prepareCall();
    public static native void setf(String expr);
    public static native void setg(String expr);
    public static native void setfdx(String expr);
    public static native void setfdx2(String expr);
    public static native String incrementalSearch(double x0, double delta, int niter);
    public static native String bisection(double xi, double xs, double tol, int niter, boolean error);
    public static native String regulaFalsi(double xi, double xs, double tol, int niter, boolean error);
    public static native String fixedPoint(double tol, double xa, double niter, boolean relativeErr);
    public static native String newtonMethod(double tol, double x0, double niter, boolean relativeErr);
    public static native String secantMethod(double tol, double x0,double x1 ,double niter, boolean relativeErr);
    public static native String mpMethod(double tol, double x0, double niter, boolean relativeErr);
}
