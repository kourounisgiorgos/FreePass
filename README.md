**HOW TO RUN**

Χρειαζεται να εχετε εγκατεστημενη την MySQL και να εχετε ενα ενεργο schema. Για να αναγνωριζει η εφαρμογη το schema σας
πηγαινετε στο application.properties αρχειο και αλλαζετε τις μεταβλητες αναλογα με τα στοιχεια της βασης σας.
Επειτε απλα πατατε run και η εφαρμογη τρεχει στo port 8080.

**USER MANUAL**

CITIZEN : Κάνετε εγγραφή στην σελίδα /register και έπειτα κάνετε login με το ονοματεπώνυμο και τον κωδικό σας. Όταν μπείτε στο profile σας το μόνο που μένει να κάνετε είναι να πατήσετε submit application, όταν έχει παρθεί απόφαση για την αίτηση σας τότε θα δείτε ένα ACCEPTED ή REJECTED στο profile σας. 

OAED : Με το προ-φτιαγμένο profile σας κάνετε login στο /oaed και έπειτα μπορείτε να δείτε την λίστα των αιτήσεων απο τους διάφορους πολίτες. Εκεί μπορείται να αποφασίσετε αν θα κάνετε accept ή reject την αίτηση πατώντας το ανάλογο κουμπί.

OASA : Με το προ-φτιαγμένο profile σας κάνετε login στο /oasa και έπειτα βλέπετε την λιστα των αποδεχόμενων αιτήσεων . Μπορείτε να ορίσετε την διάρκεια του πάσου και έπειτα να εκδόσετε το πάσο πατώντας generate.

ADMIN : Κάνετε login στο /admin και αφου έχετε παραλάβει email αίτησης είτε από το ίδρυμα του ΟΑΣΑ είτε από το ίδρυμα του ΟΑΕΔ τότε φτιάχνετε έναν λογαριασμό ανάλογα με τις απαιτήσεις του email γεμίζοντας τα user-name και password πεδία και πατώντας το κατάλληλο κουμπί.


**API DOCUMENTATION**

## 1.

path="/saveApplication" , Method=POST , authentication=CITIZEN_ROLE

 

    Headers: Content-Type", "application/json"
    Body: {
              "userName": full_name,
              "ssn":ssn,
              "unemployedSince" : unemployed
           }

*Description*:
Ο πολιτης καλει το API για να εκτελεσει την αιτηση του.
Επιτρεπεται μονο μια αιτηση ανα χρηστη και το API δεν επιτρεπει duplicates.
Για status_code = 400 σημαινει οτι εντοπιστηκε duplicate.


## 2.

path="/saveCitizen", Method=POST, authentication=ALL

    Headers: Content-Type", "application/json"

    Body:{
             "userName": first_name + " " + last_name,
             "ssn":ssn,
             "email": email,
             "status":"waiting",
             "phoneNumber": phone,
             "unemployedSince" : date
          }

*Description*:
Χρησιμοποιειται απο τους πολιτες για να αποθηκεύσει τα στοιχεια του στην βαση μας.
Αυτο το api καλειται σε συνδυασμο με το /saveUser 
και δεν θα επρεπε να καλεστει αν το response του saveUser ειναι status code 400.


## 3.

path="/updateCitizen/{user_name}" , Method=PUT , authentication=OAED_ROLE

    Headers: Content-Type", "application/json"
    Βοdy:"waiting"/"accepted"/"rejected"

*Description*:
Καλειται απο τον υπαλληλο ΟΑΕΔ για να επικυρωσει την αποφαση για την αιτηση ενος πολιτη.
Δεχεται ως παραμετρο το username του πολιτη που θελουμε να τροποποιησουμε,
αναγκαστικα πρεπει να δεχεται μια απο τις τιμες waiting/accepted/rejected

## 4.

path="/saveUser" , Method=POST authentication=ALL

    Headers: Content-Type", "application/json"
    Body:{
            "userName": user_name,
            "password": password,
            "roles": role,
         }

*Description*:
Μπορει να χρησιμοποιηθει απο τον πολιτη για την δημιουργια λογαριασμου πολιτη και επισης μπορει
ο μοναδικος admin του συστηματος να προσθεσει oaed/oasa λογαριασμο στο συστημα
Επιτρεπεται μονο ενας χρηστης ανα ονομα και το API δεν επιτρεπει duplicates.
Για status_code = 400 σημαινει οτι εντοπιστηκε duplicate.
