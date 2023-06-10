import datetime
import os
import psutil
import time
from sys import *
import os


def ProcessDisplay(log_dir = "Logs"):
    listprocess = []

    if not os.path.exists(log_dir):
        try:
            os.mkdir(log_dir)
        except:
            pass

    seperator = "-" * 80
    log_path = os.path.join(log_dir,"MarvellousLog%s.log"%(time.ctime()))
    # log_path = os.path.join(log_dir,"ProcessLog%s.log"%(datetime.date.today()))
    log_path = log_path.replace(":","_")
    f = open(log_path,'w')
    f.write(seperator + "\n")
    f.write("Marvellous Infosystems Process Logger : "+time.ctime() + "\n")
    f.write(seperator + "\n")

    for proc in psutil.process_iter():
        try:
            pinfo = proc.as_dict(attrs=['pid','name','username'])
            vms = proc.memory_info().vms / (1024 * 1024)
            pinfo['vms'] = vms
            listprocess.append(pinfo)
        except (psutil.NoSuchProcess, psutil.AccessDenied, psutil.ZombieProcess):
            pass

    for element in listprocess:
        f.write("%s\n " % element)

def main():
    print("----------Shreyash Padeer Automations-----------")

    print("Application name : " + argv[0])

    if(len(argv) != 2):
        print("Error : Invalid number of arguments")
        exit()

    if(argv[1] == "-h" or argv[1] == "-H"):
        print("This Script is used to log the record of running processess")
        exit()

    if (argv[1] == "-u" or argv[1] == "-U"):
        print("Usage : ApplicationName AbsolutePath_of_Directory")
        exit()

    try:
        ProcessDisplay(argv[1])

    except ValueError:
        print("Error : Invalid datatype of input")

    except Exception as e:
        print("Error : Invalid Input")
        print(e)

if __name__ == "__main__":
    main()