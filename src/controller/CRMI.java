package controller;

import view.VRMI;
import model.MRMI;

//public abstract class CRMI<M extends Model, V extends View> {
//public abstract class CRMI extends Controller<M extends MRMI, V extends VRMI> {
public abstract class CRMI<M extends MRMI, V extends VRMI> extends Controller<M, V> {

}
