# ---------------------------------------------------------------------
# This program is a copy from privateeyepi.com.
# It is modified to send data received from a serial port
# to a UDP receiver.
# 
# The companion code written in Java is as follows:
# import java.net.*;
# import java.lang.*;

#public class UdpRcvr {
#  public static void main (String[] args) throws Exception {
#    DatagramSocket datagramSocket = new DatagramSocket(9999);
#    byte[] buffer = new byte[12];
#    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
#
#    for (;;) {
#      System.out.print("Receiving .... ");
#      datagramSocket.receive(packet);
#      System.out.println(new String(packet.getData()));
#    }
#
#  }
#}

# ---------------------------------------------------------------------
import socket
import serial
import time
import sys
from time import sleep

def main():
    # declare to variables, holding the com port we wish to talk to and the speed
    port = '/dev/ttyAMA0'
    baud = 9600
        
    # open a serial connection using the variables above
    ser = serial.Serial(port=port, baudrate=baud)
        
    # wait for a moment before doing anything else
    sleep(0.2)
    
    print "Please wait max 5 mins for the zone transmitter to transmit..."
    
    while True:
        while ser.inWaiting():
            # read a single character
            char = ser.read()
            # check we have the start of a LLAP message
            if char == 'a':
                # start building the full llap message by adding the 'a' we have
                llapMsg = 'a'
                                
                # read in the next 11 characters form the serial buffer
                # into the llap message
                llapMsg += ser.read(11)
                                
                # now we split the llap message apart into devID and data
                devID = llapMsg[1:3]
                data = llapMsg[3:]
                buttonAB = llapMsg[3:10]
                onoff = llapMsg[10:]
                
                event = "ZONE"
                event += devID
                if onoff == "OF":
                    event += ":FAULT"
                else:
                    event += ":NOFAULT"
                event += ":" + devID + "." + buttonAB

                print "Device Number : " + devID
                print "Zone data : " + data

                sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
                sock.sendto(event, ('127.0.0.1', 9999))
                sock.sendto(event, ('pidev1', 9999))
                sock.sendto(event, ('pidev2', 9999))
                sock.sendto(event, ('pidev3', 9999))
                sock.sendto(event, ('pidev4', 9999))
                sock.sendto(event, ('pidev5', 9999))
                sock.sendto(event, ('pidev6', 9999))
                sock.sendto(event, ('pidev7', 9999))
                sock.sendto(event, ('SaintGoretti', 9999))
                
                print "event: " + event
                
                sleep(0.2)
   
if __name__ == "__main__":
    main()


