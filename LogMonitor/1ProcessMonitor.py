import psutil

def ProcessDisplay():
    listprocess = []

    # .process_iter() :- Return a sorted list of current running PIDs.
    # To iterate over all processes and avoid race conditions
    # process_iter() should be preferred.
    for proc in psutil.process_iter():
        try:
            pinfo = proc.as_dict(attrs=['pid','name','username'])
            listprocess.append(pinfo)
        except(psutil.NoSuchProcess, psutil.AccessDenied, psutil.ZombieProcess):
            pass

    return listprocess

def main():
    print("----------Shreyash Padeer Automations---------")
    print("Process Monitor")

    listprocess = ProcessDisplay()

    for elem in listprocess:
        print(elem)


if __name__ == "__main__":
    main()
