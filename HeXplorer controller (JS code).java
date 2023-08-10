package org.appinventor;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.ListPicker;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.SpeechRecognizer;
import com.google.appinventor.components.runtime.BluetoothClient;
import com.google.appinventor.components.runtime.util.YailList;
class Screen1 extends Form implements HandlesEventDispatching {
  private ListPicker ListPicker1;
  private Button Button2;
  private Label Label1;
  private Button Button3;
  private Button Button4;
  private Label Label2;
  private Button Button5;
  private SpeechRecognizer SpeechRecognizer1;
  private BluetoothClient BluetoothClient1;
  protected void $define() {
    this.AlignHorizontal(3);
    this.AlignVertical(2);
    this.AppName("Hexapod");
    this.BackgroundImage("wallpaper.jpg");
    this.Title("Screen1");
    ListPicker1 = new ListPicker(this);
    ListPicker1.BackgroundColor(0xFF0000FF);
    ListPicker1.ItemBackgroundColor(0xFF0000FF);
    ListPicker1.Shape(1);
    ListPicker1.Text("Connect to Bluetooth");
    ListPicker1.TextColor(0xFFFFFFFF);
    Button2 = new Button(this);
    Button2.BackgroundColor(0xFF000000);
    Button2.Text("Voice Control");
    Button2.TextColor(0xFFFFFFFF);
    Label1 = new Label(this);
    Label1.Text("Connection status:");
    Label1.TextColor(0xFFFFFFFF);
    Button3 = new Button(this);
    Button3.BackgroundColor(0xFF000000);
    Button3.Shape(1);
    Button3.Text("Forward");
    Button3.TextColor(0xFFFFFFFF);
    Button4 = new Button(this);
    Button4.BackgroundColor(0xFF000000);
    Button4.Shape(1);
    Button4.Text("Backward");
    Button4.TextColor(0xFFFFFFFF);
    Label2 = new Label(this);
    Label2.Text("Commands");
    Label2.TextColor(0xFFFFFFFF);
    Button5 = new Button(this);
    Button5.BackgroundColor(0xFF000000);
    Button5.Text("STOP");
    Button5.TextColor(0xFFFF0000);
    SpeechRecognizer1 = new SpeechRecognizer(this);
    BluetoothClient1 = new BluetoothClient(this);
    EventDispatcher.registerEventForDelegation(this, "ClickEvent", "Click" );
    EventDispatcher.registerEventForDelegation(this, "AfterGettingTextEvent", "AfterGettingText" );
    EventDispatcher.registerEventForDelegation(this, "AfterPickingEvent", "AfterPicking" );
    EventDispatcher.registerEventForDelegation(this, "BeforePickingEvent", "BeforePicking" );
  }
  public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params){
    if( component.equals(Button5) && eventName.equals("Click") ){
      Button5Click();
      return true;
    }
    if( component.equals(SpeechRecognizer1) && eventName.equals("AfterGettingText") ){
      SpeechRecognizer1AfterGettingText((String)params[0]);
      return true;
    }
    if( component.equals(ListPicker1) && eventName.equals("AfterPicking") ){
      ListPicker1AfterPicking();
      return true;
    }
    if( component.equals(Button3) && eventName.equals("Click") ){
      Button3Click();
      return true;
    }
    if( component.equals(Button4) && eventName.equals("Click") ){
      Button4Click();
      return true;
    }
    if( component.equals(ListPicker1) && eventName.equals("BeforePicking") ){
      ListPicker1BeforePicking();
      return true;
    }
    if( component.equals(Button2) && eventName.equals("Click") ){
      Button2Click();
      return true;
    }
    return false;
  }
  public void Button5Click(){
    BluetoothClient1.SendText("S");
  }
  public void SpeechRecognizer1AfterGettingText(String result){
    Label2.Text(0);
    if(Label2.Text().equals("forward")){
      BluetoothClient1.SendText("f");
    }
    if(Label2.Text().equals("backward")){
      BluetoothClient1.SendText("b");
    }
    if(Label2.Text().equals("stop")){
      BluetoothClient1.SendText("S");
    }
    result
  }
  public void ListPicker1AfterPicking(){
    ListPicker1.Selection(BluetoothClient1.Connect(ListPicker1.Selection()));
    if(BluetoothClient1.IsConnected()){
      Label1.Text("Bluetooth is connected.");
    }
  }
  public void Button3Click(){
    BluetoothClient1.SendText("f");
  }
  public void Button4Click(){
    BluetoothClient1.SendText("b");
  }
  public void ListPicker1BeforePicking(){
    ListPicker1.Elements(YailList.makeList(BluetoothClient1.AddressesAndNames()));
  }
  public void Button2Click(){
  }
}