# Note : please make a info.py files and set the variables as instructed for testing the code

import smtplib
import imaplib
from email.message import EmailMessage
import email
import time
import random
import datetime

from myinfo import MYMAIL, MYPASSWORD

# /////////////////////////////////////////////////////////
# //
# // Function name : Check_inbox() -> {Reply(), Add_Label}
# // Input :         Store your email and password in info.py file as-
# //                    MYMAIL = 'MailId@gmail.com'
# //                    MYPASSWORD = 'Password'
# // Output :       mail sent to ****
# // Description :   It is an automatic e-mail replier which checks for new mails every 45 to 120 seconds and replies and add label to those mails
# // Author :        Shreyash Padeer
# // Date :          02/06/2023
# //
# /////////////////////////////////////////////////////////

 # Add a label to the replied email
def Add_Label(mail, uid):
    label = 'Checked'
    mail.create(label)

    # mail.uid('STORE', uid, '+X-GM-LABELS', label)
    mail.store(uid, '+X-GM-LABELS' ,label)

# Generate and send reply 
def Reply(original):

    server = smtplib.SMTP('smtp.gmail.com',587)
    server.starttls()
    server.login(MYMAIL, MYPASSWORD)

    msg = EmailMessage()
    msg['Message-ID'] = email.utils.make_msgid()
    msg['In-Reply-To'] = original['Message-ID']
    msg['References'] = original['Message-ID']
    msg['Subject'] = "Re:" + original['Subject']
    msg['From'] = MYMAIL
    msg['To'] = original['Reply-To'] or original['From']
    msg.set_content('This is an auto generated email. I am on vacation and will reply you asap. \nThankYou!')

    server.send_message(msg)
    print('Mail sent to : ' + msg['To'])

# Checking for new emails
def Check_inbox():
    host = 'imap.gmail.com'
    mail = imaplib.IMAP4_SSL(host, 993)
    mail.login(MYMAIL, MYPASSWORD)
    mailbox = 'INBOX'
    mail.select(mailbox)

#                                 charset   criteria
    _, searched_data = mail.search(None, "(UNSEEN UNANSWERED)")
    mail_id_list = searched_data[0].split()
    
    for uid in mail_id_list:
        _, mail_data = mail.fetch(uid, "(RFC822)")
        _, data = mail_data[0]
        message = email.message_from_bytes(data)

        Reply(message)
        Add_Label(mail, uid)
    mail.logout()

if __name__ == "__main__":
    cnt = 1
    while(True):
        Check_inbox()
        current_time = datetime.datetime.now()
        print(f"cycle : {cnt} at time {current_time}")
        cnt += 1
        
        time.sleep(random.randint(45, 120))