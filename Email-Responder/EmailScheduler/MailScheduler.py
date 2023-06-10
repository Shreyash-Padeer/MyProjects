#  Process Log with Periodic Mail Sending

import os
import time
import psutil
import smtplib
import schedule
from sys import *
from email import encoders
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email.mime.multipart import MIMEMultipart

def is_connected():
    try:
        urllib2.urlopen('http://216')
