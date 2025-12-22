# 🧠 Coachly – Documentazione Completa

## 📌 Visione

Coachly è una piattaforma integrata per il fitness e la performance sportiva che unisce tecnologia, intelligenza artificiale e community per creare un ecosistema completo in cui **allenatori e atleti collaborano, migliorano e crescono insieme**.

---

## 🚀 Obiettivi del Progetto

* **Digitalizzare il rapporto allenatore–atleta** in un ambiente fluido, sicuro e interattivo.
* **Centralizzare** tutti gli strumenti di gestione (schede, progressi, media, comunicazione).
* **Ridurre la distanza** tra il mondo del coaching tradizionale e quello digitale.
* **Aumentare la qualità** degli allenamenti grazie all’analisi dati e al supporto dell’IA.

---

## ⚙️ Architettura Tecnica

### **Backend**

* **Framework:** Spring Boot 3
* **Database:** PostgreSQL
* **Storage media:** microservizio esterno (Spring Boot standalone) → MinIO o S3
* **Autenticazione:** JWT + ruoli (Coach / Atleta / Admin)
* **Design:** architettura modulare con service layer, DTO, repository, mappers
* **API:** RESTful (versionate, documentate via OpenAPI/Swagger)
* **Integrazioni future:** WebSocket, AI Engine (per suggerimenti dinamici), Analytics.

### **Frontend**

* **Web:** Angular 19 (Admin Panel + WebApp)
* **Mobile:** Flutter (in valutazione per cross-platform)
* **UI:** moderna, responsive, dark/light mode, multi-lingua
* **Design system:** PrimeNG o Material (a seconda del modulo)

### **DevOps**

* **Build:** Maven + Docker
* **CI/CD:** Jenkins
* **Testing:** JUnit, Mockito, Cypress (per e2e)
* **Deployment:** container su cluster (Kubernetes o Docker Compose iniziale)

---

## 🧩 Moduli Funzionali

### 1. **Gestione Esercizi**

* Database centralizzato di esercizi con:

    * nome, descrizione, muscoli coinvolti, difficoltà, attrezzatura, biomeccanica.
    * media (foto, video, animazioni).
    * traduzioni multilingua e consigli tecnici.
* API di ricerca, filtro e suggerimento automatico.
* Supporto per **caricamento media via microservizio** dedicato.

### 2. **Schede di Allenamento**

* Composizione di allenamenti personalizzati.
* Parametri flessibili (serie, ripetizioni, tempi, carichi).
* Possibilità di clonare, modificare o condividere schede.
* Pianificazione settimanale o ciclica.

### 3. **Monitoraggio Progressi**

* Tracking automatico dei miglioramenti.
* Grafici e statistiche (peso, carichi, performance).
* Storico delle schede e confronti temporali.
* Esportazione dei dati in PDF o CSV.

### 4. **Comunicazione & Community**

* Chat integrata tra coach e atleti.
* Gruppi di allenamento, community e ranking.
* Sfide tra utenti e gamification (badge, punti esperienza).

### 5. **AI & Suggerimenti Automatici**

* Suggerimento esercizi e schede in base al profilo e progressi.
* Generazione automatica di schede con IA (in futuro: modello fine-tuned su dataset Coachly).
* Analisi biomeccanica basata su dati video o cronologia allenamenti.

### 6. **Gestione Coach**

* Dashboard allenatore con lista atleti.
* Strumenti di comunicazione e analisi.
* Offerta di servizi (schede, abbonamenti, feedback).
* Gestione economica con pagamenti integrati (Stripe, PayPal).

---

## 🧠 Roadmap di Sviluppo (versione 1.0–2.0)

| Fase                        | Obiettivo                            | Stato                      |
| --------------------------- | ------------------------------------ | -------------------------- |
| **1.0 – Core Backend**      | Servizi Spring Boot + DB esercizi    | ✅ completato in gran parte |
| **1.1 – Media Service**     | Microservizio upload/download sicuro | 🔄 in pianificazione       |
| **1.2 – Admin Panel**       | Angular app per gestione contenuti   | 🔄 pianificato             |
| **1.3 – Flutter MVP**       | App mobile base con autenticazione   | ⏳ da avviare               |
| **1.4 – Workout Engine**    | Gestione schede e progressi          | ⏳ da avviare               |
| **1.5 – Community & Chat**  | Social features e ranking            | 🔜                         |
| **2.0 – AI & Suggerimenti** | Modulo di intelligenza artificiale   | 🔮                         |

---

## 🔒 Sicurezza e Privacy

* Accesso autenticato tramite **JWT + ruoli**.
* Link firmati per media e documenti.
* Crittografia per dati sensibili.
* Policy GDPR-ready (consenso, cancellazione dati, portabilità).

---

## 🌍 Internazionalizzazione

* Gestione dinamica delle lingue tramite tabelle i18n.
* Traduzioni automatizzabili via AI (opzionale).
* Localizzazione di nomi esercizi, categorie e istruzioni.

---

## 🧰 Stack Tecnologico

| Livello      | Tecnologia                              |
| ------------ | --------------------------------------- |
| Backend      | Java 21, Spring Boot                    |
| DB           | PostgreSQL                              |
| File Storage | MinIO                                   |
| Frontend     | Angular / Flutter                       |
| Auth         | JWT                                     |
| CI/CD        | Jenkins                                 |
| Container    | Docker                                  |
| AI (futuro)  | TensorFlow Lite / PyTorch backend       |
| Hosting      | Scalabile su cloud (AWS / Render / GCP) |

---

## 📈 Differenziazione da altri competitor

* Integrazione **reale e simmetrica** tra coach e atleta (non solo schede precompilate).
* **Microservizi modulari**, scalabili, riutilizzabili in altri tuoi progetti.
* Possibilità di **funzionamento offline** e sincronizzazione differita.
* Focus su **personalizzazione e automazione**, non solo gestione.
* Design curato, UX fluida e moderna.

---

## 💬 Futuri sviluppi

* Rilevamento automatico dei movimenti (via AI + fotocamera).
* Algoritmi di ottimizzazione del carico.
* Suggerimenti automatici di dieta.
* Integrazione con smartwatch e fitness tracker.
* Marketplace di piani e schede tra coach.
