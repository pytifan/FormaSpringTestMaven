#! /usr/bin/python
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#__author__="alex"
#__date__ ="$Apr 24, 2014 2:44:26 PM$"
#if __name__ == "__main__":
#    print "Hello World";
from jython import AutomobileType
class Automobile(AutomobileType, object):
    ''' Bean to hold automobile objects '''

    def __init__(self):
        print 'Initializing Now'
        pass

    def setType(self, value):
        self.__type = value
        print 'setting object: ' + value

    def getType(self):
        print 'getting object'
        return self.__type

    type = property(fget=getType,
                    fset=setType,
                    doc="The Type of the Automobile.")

    def setColor(self, value):
        self.__color = value

    def getColor(self):
        return self.__color

    def getDoc(self):
        return self.__doc__



    color = property(fget=getColor,
                     fset=setColor,
                     doc="Color of Automobile.")