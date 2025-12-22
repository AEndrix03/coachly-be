# 🏋️‍♂️ Coachly — Design System & UI/UX Guidelines

**Documento per il Team di Design Mobile**  
*Versione 1.0 — App Flutter per utenti finali*

---

## 🎯 Visione e Filosofia

Coachly non è semplicemente un'app per il fitness: è un **ecosistema intelligente** che trasforma il modo in cui le
persone si allenano, progrediscono e si connettono con professionisti e community. L'esperienza deve comunicare *
*potenza, precisione e personalità**, fondendo tecnologia avanzata con un design che ispira costanza e miglioramento
continuo.

### Principi Guida del Design

**Intelligenza Invisibile**  
L'intelligenza artificiale è il cuore pulsante di Coachly, ma non deve mai sembrare invadente o complessa. Deve
manifestarsi come un compagno silenzioso che anticipa i bisogni, suggerisce al momento giusto e celebra ogni progresso.
L'utente deve percepire l'AI come un coach digitale sempre presente ma mai ingombrante.

**Semplicità Radicale**  
Ogni funzione complessa deve risultare semplice. L'inserimento vocale trasforma ore di data entry in secondi di
conversazione naturale. I grafici raccontano storie senza richiedere analisi. Le schede si adattano automaticamente. La
complessità esiste nel backend, non nell'interfaccia.

**Motivazione Visiva**  
Ogni elemento grafico deve contribuire alla motivazione dell'utente. I progressi sono celebrati con animazioni
soddisfacenti, i colori evolvono con le performance, i badge brillano al raggiungimento di traguardi. L'app non registra
solo dati: celebra vittorie.

**Professionalità Accessibile**  
Coachly deve apparire professionale quanto le piattaforme usate dai coach certificati, ma accessibile come le app
consumer più amate. Il design bilancia autorevolezza scientifica con calore umano, precisione tecnica con empatia
visiva.

---

## 🎨 Identità Visiva

### Palette Cromatica

**Base Scura — "Midnight Performance"**  
Lo sfondo principale è un nero profondo (```#0A0A0F```) con sfumature grigio antracite (```#1A1A24```) per creare
profondità senza affaticare gli occhi durante sessioni prolungate. Questa base scura esalta gli accenti brillanti e
comunica serietà professionale.

**Accenti Primari — "Neural Blue"**  
Il blu elettrico (```#0066FF``` → ```#00A3FF```) rappresenta l'intelligenza artificiale e le azioni principali. Questo
colore deve apparire luminoso, quasi neon, con un leggero glow nei pulsanti d'azione. Le variazioni di questo blu
seguono uno spettro che va dal profondo (riposo, recupero) al brillante (azione, energia).

**Accenti Secondari — "Velocity Purple"**  
Il viola neon (```#8B5CF6``` → ```#A78BFA```) rappresenta la gamification, i progressi personali e le zone AI avanzate.
Questo colore appare nei badge, nei rank e nelle celebrazioni di traguardi raggiunti.

**Stati Positivi — "Growth Green"**  
Il verde brillante (```#10B981```) comunica progresso, completamento e miglioramento. Appare nei check, nelle barre di
completamento e nei feedback positivi. Mai un verde spento: sempre vivido e energizzante.

**Alert e Sicurezza — "Amber Warning"**  
Il giallo ambrato (```#F59E0B```) evidenzia note di sicurezza, controindicazioni e attenzioni biomeccaniche. Utilizzato
con parsimonia per mantenere l'attenzione su elementi critici senza creare ansia.

**Gradienti Dinamici**  
I gradienti sono utilizzati per creare profondità e movimento. Esempi:

- **AI Gradient**: ```linear-gradient(135deg, #667eea 0%, #764ba2 100%)```
- **Energy Gradient**: ```linear-gradient(90deg, #00F260 0%, #0575E6 100%)```
- **Performance Gradient**: ```linear-gradient(45deg, #FA8BFF 0%, #2BD2FF 50%, #2BFF88 100%)```

### Tipografia

**Font Primario — Poppins**  
Utilizzato per titoli, intestazioni e testi principali. La sua geometria pulita e i pesi variabili (da Light a Bold) lo
rendono perfetto per gerarchie chiare. I titoli principali usano Poppins SemiBold o Bold (600-700), mentre i body text
usano Regular o Medium (400-500).

**Font Secondario — Inter**  
Utilizzato per testi descrittivi, caption e elementi di interfaccia. La sua leggibilità eccellente anche a dimensioni
ridotte lo rende ideale per statistiche, numeri e dettagli tecnici.

**Font Numerico — SF Mono / Roboto Mono**  
Per visualizzare carichi, ripetizioni, timer e statistiche. Il carattere monospazio trasmette precisione e facilita la
lettura rapida di valori numerici durante l'allenamento.

**Gerarchia Tipografica**

- **H1 (Screen Title)**: Poppins Bold, 32px, letter-spacing: -0.5px
- **H2 (Section Header)**: Poppins SemiBold, 24px
- **H3 (Card Title)**: Poppins Medium, 18px
- **Body Large**: Inter Regular, 16px, line-height: 1.6
- **Body Regular**: Inter Regular, 14px, line-height: 1.5
- **Caption**: Inter Regular, 12px, opacity: 0.7
- **Numbers/Stats**: SF Mono Medium, variable size

### Iconografia

**Stile delle Icone**  
Le icone seguono uno stile lineare minimal con peso uniforme (2px stroke). Ogni icona deve essere riconoscibile
istantaneamente anche a dimensioni ridotte. Lo stato attivo è comunicato attraverso:

- Fill completo del path
- Glow effect con shadow colorato
- Micro-animazione scale (1.0 → 1.1 → 1.0)

**Set Iconografico Custom**  
Ogni sezione principale ha un'icona caratteristica con varianti stato:

- **Community**: icona persone con cerchi connessi (simbolo connessione)
- **Workouts**: bilanciere stilizzato o manubrio in prospettiva
- **Home**: casa con pulsazione centrale (heartbeat effect)
- **WIP**: ingranaggio con particelle luminose
- **Coach**: figura umana con badge o fischietto stilizzato

**Animazioni Iconografiche**  
Le icone rispondono al tocco con:

- Tap: scale bounce (1.0 → 0.95 → 1.05 → 1.0) in 200ms
- Stato attivo: glow pulsante continuo
- Transizione di stato: morph fluido tra outline e filled

### Animazioni e Transizioni

**Principi di Movimento**  
Ogni animazione deve sentirsi **fluida ma energica**, mai lenta o pesante. La velocità comunica l'intelligenza del
sistema: risposte istantanee, transizioni morbide, feedback immediato.

**Timing e Easing**

- **Micro-interazioni**: 150-200ms, easing ```cubic-bezier(0.4, 0.0, 0.2, 1)```
- **Transizioni schermata**: 300-400ms, easing ```cubic-bezier(0.25, 0.1, 0.25, 1)```
- **Animazioni AI**: 500-800ms, easing custom per effetto "pensante"
- **Celebrazioni**: 1000-1500ms, easing ```cubic-bezier(0.68, -0.55, 0.265, 1.55)``` (bounce)

**Libreria di Animazioni**

- **Fade-in**: apparizione morbida per nuovi contenuti
- **Slide-up**: apertura modale dal basso con backdrop blur
- **Scale-bounce**: feedback tattile per pulsanti
- **Progress-fill**: barre che si riempiono con gradiente animato
- **Shimmer-loading**: placeholder animato durante caricamento
- **Particle-burst**: celebrazione completamento con particelle colorate
- **Glow-pulse**: respiro luminoso per elementi AI attivi
- **Morph-transition**: trasformazione fluida tra stati (es. play → pause)

---

## 🧭 Navigazione e Architettura

### Bottom Navigation Bar

La navigazione principale è una bottom bar fissa che rimane sempre accessibile, con sfondo semi-trasparente (
glassmorphism) che sfuma dolcemente sul contenuto sottostante. La bar ha un leggero elevation e un sottile border top
luminoso.

**Struttura Fisica**

- **Altezza**: 70px (include safe area)
- **Backdrop**: blur(20px) + opacity 0.95
- **Border top**: 1px solid rgba(255,255,255,0.1)
- **Shadow**: 0 -4px 20px rgba(0,0,0,0.3)

**Comportamento**

- Rimane fissa durante lo scroll
- Leggerissima animazione slide-down quando si scorre verso il basso
- Riappare immediatamente scrollando verso l'alto
- Gli elementi non selezionati hanno opacity 0.5
- L'elemento attivo ha scala 1.1 e glow effect

**Anatomia di Ogni Tab**  
Ogni icona nella bottom bar presenta:

- **Icona**: 24x24px, design lineare
- **Label**: 10px sotto l'icona, solo per tab attivo
- **Indicatore**: pill shape dietro l'icona attiva (32x32px, blur background)
- **Badge**: notifiche numeriche (10x10px, rosso, posizione top-right dell'icona)

**Stati Visivi**

```
Inattivo:
- Icona: bianco opacity 0.5
- Label: nascosta
- Nessun glow

Attivo:
- Icona: colore primario pieno + glow
- Label: visibile con fade-in
- Pill background animato
- Micro-bounce all'attivazione

Pressed:
- Scale 0.95 per 100ms
- Feedback haptic leggero
```

### Transizioni Tra Sezioni

Quando l'utente cambia tab, la transizione deve essere **cross-fade fluida** con leggero slide laterale (30px):

- La schermata uscente: fade-out + slide-left (se si va a destra)
- La schermata entrante: fade-in + slide-right

Durata totale: 300ms con easing ```cubic-bezier(0.4, 0.0, 0.2, 1)```

---

## 👥 COMMUNITY — "Athletic Social Network"

### Filosofia della Sezione

La Community di Coachly non è un social network tradizionale: è uno spazio professionale dove atleti e coach condividono
**progressi reali, consigli tecnici e motivazione autentica**. Nessun elemento infantile o "cringe": qui si parla di
performance, biomeccanica e crescita personale.

### Struttura Generale

**Header Persistente**  
In cima alla schermata, un header fisso (60px) con:

- **Titolo sezione**: "Community" in Poppins SemiBold 24px
- **Icone azione destra**:
    - Filtri (icona funnel): apre modal con opzioni di filtraggio
    - Cerca (icona lente): espande search bar
    - Notifiche (icona campana): mostra badge se presenti

**Sezione Stories/Highlights**  
Immediatamente sotto l'header, una striscia orizzontale scorrevole (80px altezza) con:

- Avatar circolari (60px) con ring colorato che indica il rank dell'utente
- Label sotto l'avatar con nome (10px)
- Tap: apre fullscreen story (vertical swipe per passare alla prossima)
- Include "La tua storia" come primo elemento con icona +
- Gli utenti con nuovi contenuti hanno ring animato pulsante

**Feed Principale**

Scroll verticale infinito con card ben spaziate. Ogni card ha:

**Anatomia di una Card Post**

```
┌─────────────────────────────────────┐
│ ┌───┐ Nome Utente                   │
│ │ A │ Elite • Livello 12      [...]│ <- Header: avatar + nome + rank + menu
│ └───┘ 2h fa                         │
├─────────────────────────────────────┤
│                                     │
│  [  Media Content Area   ]          │ <- Immagine/Video full-width
│                                     │
├─────────────────────────────────────┤
│ Caption text con possibile          │
│ #hashtag e @mention colorati        │ <- Body: testo con markdown light
├─────────────────────────────────────┤
│ ❤️ 234   💬 45   🔁 12              │ <- Footer: interazioni
└─────────────────────────────────────┘
```

**Design Dettagliato**

- **Card background**: ```#1A1A24``` con border-radius 16px
- **Padding**: 16px interno, 16px margin verticale tra card
- **Elevation**: shadow sottile ```0 2px 12px rgba(0,0,0,0.2)```
- **Media**: aspect ratio 4:3 per immagini, video con controlli minimali
- **Text**: Inter Regular 14px, line-height 1.6, max 4 righe visibili (espandibile con "Mostra altro")

**Header Post**  
L'header di ogni post mostra l'identità dell'autore:

- **Avatar**: 40x40px, border 2px con colore rank
- **Nome**: Poppins Medium 15px
- **Rank badge**: piccolo tag (es. "Elite") con colore brand
- **Timestamp**: Inter Regular 12px, opacity 0.6
- **Menu (...)**: kebab menu per azioni (segnala, condividi, salva)

**Rank Colors System**  
Il border dell'avatar e il badge cambiano colore in base al livello:

- **Newcomer** (1-5): Grigio ```#6B7280```
- **Dedicated** (6-10): Blu ```#3B82F6```
- **Elite** (11-15): Viola ```#8B5CF6```
- **Pro** (16-20): Oro ```#F59E0B```
- **Champion** (21+): Platino con gradient ```linear-gradient(135deg, #667eea, #f3d7ef)```

**Media Content**

- **Immagini**: caricamento progressivo con blur-up, pinch-to-zoom al tap
- **Video**: autoplay muted in feed, unmute al tap, controlli minimal overlay
- **Carousel**: se post multiplo, dots indicator in basso, swipe orizzontale
- **Video AI Analysis**: se l'utente ha caricato un video di esecuzione, badge "Analizzato da AI" con icona cervello

**Interazioni**  
Le icone di interazione sono sempre presenti alla base della card:

**Like (Cuore)**

- Stato inattivo: outline, bianco 50%
- Tap: animazione burst + fill rosso + haptic
- Stato attivo: filled rosso con micro-pulse
- Long press: apre "Chi ha messo like"

**Commenta (Fumetto)**

- Tap: apre slide-up modal con tastiera e lista commenti
- Se ci sono commenti: numero visibile a destra dell'icona
- Se l'utente ha commentato: icona accent color

**Condividi (Frecce)**

- Tap: apre bottom sheet con opzioni:
    - Condividi in Community
    - Invia a un coach
    - Copia link
    - Condividi su esterni (iOS share sheet)

**Salvato (Bookmark)**

- Icona separata a destra
- Tap: salva nei preferiti con animazione scale
- Accesso rapido a contenuti salvati da profilo

### Filtri e Ricerca

**Modal Filtri**  
Toccando l'icona filtro nell'header, appare una modal slide-up con:

- **Tipo contenuto**: Toggle chips (Tutti / Progressi / Guide / Video Form Check)
- **Autore**: Tutti / Solo Coach / Solo seguiti
- **Periodo**: Ultima settimana / Mese / Sempre
- **Muscoli/Focus**: Select multiplo con visual muscle map
- **Pulsanti**: "Resetta" (ghost) + "Applica" (primario)

**Ricerca**  
La search bar si espande dall'icona lente con animazione fluida:

- Background blur con backdrop
- Input con placeholder "Cerca atleti, post, #hashtag..."
- Suggerimenti real-time mentre si digita
- Risultati divisi in: Persone / Post / Hashtag / Coach

### Stories Format

Le stories si aprono fullscreen con gesture naturali:

- **Swipe down**: chiude la story
- **Tap left/right**: storia precedente/successiva
- **Tap centro**: pausa
- **Hold**: pausa prolungata

**Elementi Story**

- Progress bar in alto (multi-segmento se più storie)
- Avatar + nome autore in alto a sinistra
- Timestamp in alto a destra
- Input reazione in basso (quick reply)
- Media fullscreen con gradiente overlay sopra/sotto per leggibilità

### AI Features nella Community

**AI Insights nei Post**  
Se un utente condivide un video di esecuzione, l'AI può analizzarlo automaticamente e mostrare un badge:

```
┌────────────────────────────────┐
│ 🧠 Analizzato da AI            │
│ Esecuzione: Ottima             │
│ ROM: 95% | Postura: ✓          │
└────────────────────────────────┘
```

**AI Challenges**  
Nella parte alta del feed, dopo le stories, card speciali per sfide generate dall'AI:

```
┌─────────────────────────────────────┐
│ ⚡ Sfida AI della Settimana         │
│ Aumenta il volume di trazione       │
│ del 10% rispetto alla scorsa sett.  │
│                                     │
│ 🏆 234 partecipanti • 3 giorni left │
│ [ Partecipa ]                       │
└─────────────────────────────────────┘
```

**Suggested Connections**  
L'AI suggerisce atleti con obiettivi simili:

- Card compatta con "Persone che potrebbero interessarti"
- 3-4 profili scorrevoli orizzontalmente
- Quick action "Segui" inline

---

## 🏋️ WORKOUTS — "Intelligent Training System"

### Filosofia della Sezione

Workouts è il cuore operativo di Coachly: qui l'utente crea, modifica e esegue le sue schede di allenamento.
L'esperienza deve risultare **potente ma semplice**, con l'AI che guida silenziosamente ogni scelta per ottimizzare
risultati e prevenire errori.

### Home Workouts

**Layout Principale**  
La schermata si apre con un hero header dinamico (200px) che mostra:

- **Background**: gradient animato con texture neural soft
- **Titolo**: "I Tuoi Allenamenti" in Poppins Bold 28px
- **Subtitle AI**: frase motivazionale contestuale (es. "Oggi è giorno gambe. Concentrati sul volume.")
- **CTA primario**: pulsante flottante "Nuova Scheda" (posizionato in basso al centro, 56x56px, blu elettrico con glow)

**Schede Recenti**  
Sotto l'header, carousel orizzontale di card con le schede recenti (max 5):

```
┌───────────────────────┐
│ PETTO & TRICIPITI     │
│ ━━━━━━━━━━━━ 80%     │ <- Progress bar
│                       │
│ 💪 12 esercizi        │
│ ⏱️ ~45 min           │
│ 🔥 Ipertrofia         │
│                       │
│ Ultima: 2 giorni fa   │
│                       │
│ [ Inizia Workout ]    │
└───────────────────────┘
```

**Design Card Scheda**

- **Dimensioni**: 280px width × 320px height
- **Background**: gradient verticale scuro → più chiaro
- **Border-radius**: 24px
- **Shadow**: elevation alta ```0 8px 24px rgba(0,0,0,0.3)```
- **Icone**: 16px, colore accent con opacity 0.8
- **CTA button**: full-width, 44px height, border-radius 12px

**Lista Completa Schede**  
Scrollando oltre il carousel, appare lista verticale con tutte le schede:

- **Sezioni**: "Attive" / "Completate" / "Archiviate"
- **Card compatte**: 90px height, layout orizzontale
- **Swipe actions**: swipe left rivela "Duplica" / "Modifica" / "Elimina"
- **Quick stats**: piccoli badge con giorni dall'ultimo workout

### Creazione Nuova Scheda

Toccando "Nuova Scheda", modal fullscreen con wizard step-by-step:

**Step 1: Obiettivo**  
Selezione visual dell'obiettivo con card grandi:

```
[ Forza ]  [ Ipertrofia ]  [ Resistenza ]
[ Definizione ]  [ Mobilità ]  [ Altro ]
```

- Card: 160x160px, icona centrale 48px, label sotto
- Stato selezionato: border accent 3px + glow
- Tap: scale animation + haptic

**Step 2: Struttura**  
L'AI suggerisce struttura ottimale:

- "Split Push/Pull/Legs" (3 giorni)
- "Upper/Lower" (4 giorni)
- "Full Body" (3 giorni)
- "Personalizzato"

**Step 3: Selezione Esercizi**  
Interfaccia potente ma intuitiva:

**Barra Ricerca Top**

- Search con filtri inline: Muscolo / Attrezzatura / Difficoltà
- Suggerimenti AI mentre si digita
- Voice input button

**Lista Esercizi**  
Ogni esercizio mostrato come card orizzontale ricca:

```
┌──────────────────────────────────────────┐
│ [Img] Panca Piana con Bilanciere     [+] │
│       Petto • Tricipiti • Spalle          │
│       ⚡ Compound  📊 Intermedio          │
│       🎥 Video  📋 Istruzioni  🧠 AI      │
└──────────────────────────────────────────┘
```

- **Thumbnail**: 80x80px, rounded 12px
- **Nome**: Poppins Medium 16px
- **Metadata**: chips piccoli con icone
- **Azioni rapide**: icone in fila (video / istruzioni / AI insights)
- **Add button**: 32x32px cerchio, animazione scale al tap

**AI Suggestions Panel**  
Pannello scorrevole in basso con suggerimenti contestuali:

```
💡 L'AI suggerisce:
▸ Aggiungi una variante inclinata per petto alto
▸ Bilancia con esercizi di trazione posteriore
▸ Considera recovery days tra sessioni pesanti
```

### Dettaglio Esercizio

Toccando un esercizio si apre sheet modale fullscreen estremamente dettagliata:

**Header Visual**

- **Media Hero**: video o immagine animata (auto-loop), aspect 16:9
- **Overlay controls**: play/pause, fullscreen, cambio angolazione
- **Header info sopra media**: nome esercizio + icone quick actions (like, share, bookmark)

**Tabs Navigazione**  
Sotto il media, tabs orizzontali:

```
[ Overview ] [ Istruzioni ] [ Biomeccanica ] [ Sicurezza ] [ Varianti ]
```

**Tab: Overview**  
Sintesi rapida con visual elements:

- **Muscoli coinvolti**: grafica anatomica interattiva (immagine corpo umano con highlight)
    - Tap su muscolo: mostra % di coinvolgimento
    - Colori: primari rosso intenso, secondari rosso chiaro
- **Metadata cards**:
  ```
  ┌──────────┬──────────┬──────────┐
  │ Difficoltà│ Mechanics│ Forza    │
  │ ⭐⭐⭐    │ Compound │ Push     │
  └──────────┴──────────┴──────────┘
  ```
- **Attrezzatura necessaria**: chips con icone

**Tab: Istruzioni**  
Step-by-step numerati con visual markers:

```
1. Posizione Iniziale
   🎯 Sdraiati sulla panca, piedi ben piantati
   🎥 [Mini video loop 3s]

2. Fase Eccentrica
   ⏬ Abbassa il bilanciere controllando la discesa
   ⚠️ Mantieni gomiti a 45° dal corpo
   
3. Fase Concentrica
   ⏫ Spingi esplosivamente verso l'alto
   💨 Espira durante la spinta
```

- Ogni step: icona visual, testo breve, eventuale micro-video
- Note critiche evidenziate con bordo giallo

**Tab: Biomeccanica**  
Sezione per utenti avanzati:

- **Range di movimento**: grafico arco articolare con angoli
- **Curve di forza**: grafico tensione muscolare nelle fasi
- **Pattern di attivazione**: timeline attivazione muscolare
- **Insights AI**: "Massima tensione a 90° di flessione gomito"

**Tab: Sicurezza**

```
⚠️ Livello Rischio: MEDIO

❌ Controindicazioni:
• Problemi spalla anteriore
• Tendinite del bicipite
• Recenti infortuni petto

✅ Consigli:
• Usa spotter per carichi massimali
• Riscaldamento specifico obbligatorio
• Evita rimbalzo sul petto
```

**Tab: Varianti**  
Carousel di esercizi correlati:

- Panca inclinata
- Panca declinata
- Panca con manubri
- Panca stretta (focus tricipiti)

Ogni variante: card compatta con immagine + nome + difficoltà delta (es. "+1 difficoltà")

### Esecuzione Workout

Quando l'utente avvia un workout, l'app entra in "Modalità Allenamento":

**Schermata Allenamento Attivo**  
Layout fullscreen con navigazione minimale:

```
┌────────────────────────────────────┐
│ ← [Pausa]          00:23:45    [✓] │ <- Header: timer centrale
├────────────────────────────────────┤
│                                    │
│     PANCA PIANA BILANCIERE         │ <- Nome esercizio grande
│     Serie 2/4                      │
│                                    │
│     [Preview Video Loop]           │ <- Media reference
│                                    │
├────────────────────────────────────┤
│  Target: 10 reps × 80 kg           │
│                                    │
│  ┌────────────────────────────┐   │
│  │ Reps:  [  8  ]  [-]  [+]   │   │ <- Input veloce
│  └────────────────────────────┘   │
│                                    │
│  ┌────────────────────────────┐   │
│  │ Peso:  [ 80  ] kg  [-] [+] │   │
│  └────────────────────────────┘   │
│                                    │
│  [ 🎤 Inserimento Vocale ]         │ <- CTA vocale grande
│                                    │
│  Timer riposo: 02:30               │ <- Countdown automatico
│                                    │
│  [ Completa Serie ]                │ <- Button primario
└────────────────────────────────────┘
```

**Caratteristiche**

- **Timer generale**: conta tempo totale workout
- **Timer riposo**: partenza automatica dopo serie completata, notifica vibrazione
- **Input numbers**: stepper con +/- e possibilità di tap per keyboard numerico
- **Voice button**: sempre visibile, pulsazione subtile per attirare attenzione
- **Video reference**: loop continuo in background, tap per fullscreen

**AI Real-Time Coaching**  
Durante l'esecuzione, l'AI può intervenire:

```
💡 Ottimo! Ultima serie hai aumentato del 10%
   Prova ad aggiungere una rep in questa
```

**Completamento Esercizio**  
Swipe up o tap "Prossimo" per passare all'esercizio successivo:

- Animazione check verde
- Micro celebrazione se PR o miglioramento
- Auto-scroll alla prossima card

**Rest Timer Intelligente**  
Il timer di riposo è gestito dall'AI:

- **Serie leggere**: 60-90 secondi
- **Serie moderate**: 90-120 secondi
- **Serie pesanti**: 2-3 minuti
- **Override manuale**: tap su timer per modificare

**Inserimento Vocale**  
Toccando il pulsante microfono:

1. Overlay fullscreen con waveform animata
2. Feedback visivo del parlato
3. Trascrizione in tempo reale
4. Parsing automatico: "tre serie da otto con ottanta" → 3×8×80kg
5. Conferma visiva prima del save

### AI Workout Intelligence

**Suggerimenti Proattivi**  
Durante la scheda, l'AI monitora e suggerisce:

```
┌─────────────────────────────────┐
│ 🧠 AI Coach                     │
│                                 │
│ Hai completato tutte le serie   │
│ di spinta. Aggiungi esercizi    │
│ di trazione per bilanciare?     │
│                                 │
│ [ Ignora ] [ Mostra Esercizi ]  │
└─────────────────────────────────┘
```

**Form Check Suggestions**  
Se l'utente carica un video:

```
📹 Vuoi che l'AI analizzi la tua esecuzione?
   • Verifica ROM
   • Analizza postura
   • Suggerisce correzioni
   
[ Analizza Video ]
```

**Progressive Overload Tracking**  
L'AI traccia automaticamente progressioni:

- Notifica quando è tempo di aumentare carico
- Suggerisce deload weeks
- Identifica plateau e propone variazioni

---

## 🏠 HOME — "Performance Command Center"

### Filosofia della Sezione

Home è il **centro nevralgico personale** dell'atleta: sintesi intelligente di tutto ciò che conta. Non è una semplice
dashboard statica, ma un assistente proattivo che cambia dinamicamente in base a progressi, orari, recupero e obiettivi.

### Architettura Visiva

**Hero Header Personalizzato**  
La parte superiore (300px circa) è un header ricco e personalizzato:

```
┌─────────────────────────────────────────┐
│  [Avatar]  Ciao, Marco! 👋              │
│  Elite • Livello 14                     │
│                                         │
│  ━━━━━━━━━━━━━━━━━━━ 75%              │ <- Progress bar XP
│  250 XP al prossimo livello             │
└─────────────────────────────────────────┘
```

**Elementi Header**:

- **Avatar**: 64x64px, border colorato con rank, tap per profilo completo
- **Nome + Saluto**: dinamico in base all'ora ("Buongiorno", "Buon pomeriggio")
- **Rank Badge**: tag inline con icona e colore
- **Progress XP**: barra progress con gradiente animato
- **Background**: gradient dinamico che varia con l'ora del giorno

**Quick Actions Bar**  
Sotto l'header, barra con 4 icone circolari rapide:

```
[ 🔔 ]  [ ⚙️ ]  [ 📊 ]  [ 🎯 ]
Notif.  Settings Stats  Goals
```

- Icone: 48x48px, circle con blur background
- Badge numerici su notifiche
- Tap: apre modal/pagina dedicata

### AI Companion Card

Immediatamente sotto quick actions, il **pannello AI più importante della Home**:

```
┌──────────────────────────────────────────┐
│ 🧠 AI Coach • Oggi                       │
├──────────────────────────────────────────┤
│                                          │
│ Analisi della tua settimana:             │
│                                          │
│ ✅ Ottima consistenza (5/5 workout)      │
│ 📈 Volume gambe +18% vs scorso mese     │
│ ⚠️ Segnali affaticamento catena post.   │
│                                          │
│ 💡 Suggerimento: oggi riposo attivo     │
│    o mobilità. Recupero = crescita!     │
│                                          │
│ [ Dettagli AI ] [ Programma Recupero ]   │
└──────────────────────────────────────────┘
```

**Caratteristiche AI Card**:

- **Background**: gradient viola-blu con texture neural sottile
- **Border**: sottile glow animato
- **Icona AI**: pulsante leggermente (breathing effect)
- **Testo**: analisi concisa ma dettagliata
- **CTAs**: max 2 azioni contestuali
- **Refresh**: aggiornamento real-time, swipe-down per refresh manuale

**AI Insights Tipologie**:

- **Motivazionali**: "Grande settimana! Sei on track per il tuo obiettivo"
- **Correttivi**: "Volume petto eccessivo. Aggiungi trazione per bilanciare"
- **Preventivi**: "Pattern indica rischio sovrallenamento. Considera deload"
- **Celebrativi**: "Nuovo PR su squat! +12kg rispetto al mese scorso 🎉"
- **Suggerimenti**: "Oggi giornata ideale per massimali. Energia alta."

### Widgets Modulari

Sotto l'AI Card, scroll verticale con widgets personalizzabili:

**Widget: Prossimo Workout**

```
┌──────────────────────────────────┐
│ Prossimo Allenamento             │
│                                  │
│ 🏋️ GAMBE & GLUTEI               │
│ 📅 Oggi • 18:30                  │
│ ⏱️ ~60 minuti                   │
│                                  │
│ 6 esercizi • Ipertrofia          │
│                                  │
│ [ Quick Start ]  [ Vedi Scheda ] │
└──────────────────────────────────┘
```

**Widget: Summary Settimanale**

```
┌──────────────────────────────────┐
│ Questa Settimana                 │
│                                  │
│ ┌────┬────┬────┬────┬────┐      │
│ │ L  │ M  │ M  │ G  │ V  │      │ <- Heatmap giorni
│ │ ✓  │ ✓  │ -  │ ✓  │ ✓  │      │
│ └────┴────┴────┴────┴────┘      │
│                                  │
│ 4 workout • 12,5 tonnellate      │
│ Streak: 3 settimane 🔥           │
│                                  │
│ [ Vedi Dettagli ]                │
└──────────────────────────────────┘
```

**Widget: Progressi Principali**

```
┌──────────────────────────────────┐
│ Progressi Chiave                 │
│                                  │
│ Panca Piana                      │
│ 85 kg → 90 kg (+6%)              │
│ ━━━━━━━━━━━━━━━ 📈              │
│                                  │
│ Squat                            │
│ 120 kg → 130 kg (+8%)            │
│ ━━━━━━━━━━━━━━━━━ 📈            │
│                                  │
│ [ Tutti i Progressi ]            │
└──────────────────────────────────┘
```

**Widget: Community Highlights**

```
┌──────────────────────────────────┐
│ Dalla Community                  │
│                                  │
│ [Mini-card post rilevante]       │
│ Coach Mario: "Tecnica stacco..." │
│                                  │
│ [ Vedi Altro in Community ]      │
└──────────────────────────────────┘
```

**Widget: Coach Updates**

```
┌──────────────────────────────────┐
│ Il Tuo Coach                     │
│                                  │
│ 💬 Nuovo messaggio da Coach Luca │
│ "Grande lavoro questa settimana" │
│                                  │
│ 📋 Nuova scheda assegnata        │
│ "Programma Forza 4 settimane"    │
│                                  │
│ [ Apri Chat ]                    │
└──────────────────────────────────┘
```

### Personalizzazione Widget

Long-press su un widget:

- Modal "Personalizza Home"
- Drag & drop per riordinare
- Toggle per mostrare/nascondere
- Dimensioni variabili (small, medium, large)

### Profilo Completo

Toccando l'avatar nell'header, si apre sheet con profilo completo:

**Sezioni Profilo**:

- **Overview**: foto grande, nome, bio, stats principali
- **Achievements**: galleria badge e titoli sbloccati
- **History**: timeline progressi nel tempo
- **Records**: lista PR personali per esercizio
- **Settings**: preferenze, privacy, account

---

## ⚙️ WORK IN PROGRESS — "Future Lab"

### Filosofia della Sezione

WIP non è un placeholder, ma uno spazio **interattivo e visionario** dove l'utente può:

- Testare funzionalità in beta
- Vedere cosa sta arrivando
- Contribuire con feedback
- Sperimentare con tool avanzati

### Design Estetico

Lo stile visivo di questa sezione deve essere **futuristico e sperimentale**:

- Palette: viola profondo, neon ciano, particelle luminose
- Animazioni: più elaborate e "tech preview"
- Componenti: glassmorphism accentuato, bordi luminosi

**Header WIP**

```
┌───────────────────────────────────┐
│      ⚙️ WORK IN PROGRESS          │
│   Laboratorio di Innovazione      │
│                                   │
│   Testa le prossime funzioni      │
│   e aiutaci a migliorare Coachly  │
└───────────────────────────────────┘
```

### Sezioni Contenuto

**Beta Features**  
Card con funzionalità in test:

```
┌────────────────────────────────────┐
│ 🧪 BETA                            │
│ Form Check AI Video                │
│                                    │
│ Carica un video e ricevi analisi   │
│ biomeccanica in tempo reale        │
│                                    │
│ ⭐ 234 tester • Feedback: 4.8/5   │
│                                    │
│ [ Prova Ora ]  [ Scopri di più ]   │
└────────────────────────────────────┘
```

**Coming Soon**  
Timeline visiva delle feature in arrivo:

```
┌────────────────────────────────────┐
│ 🔮 IN ARRIVO                       │
│                                    │
│ Q2 2026                            │
│ ├─ Integrazione Smartwatch         │
│ ├─ Nutrizione AI Completa          │
│ └─ Marketplace Schede Coach        │
│                                    │
│ Q3 2026                            │
│ └─ Analisi Posturale 3D            │
└────────────────────────────────────┘
```

**Tool Sperimentali**  
Piccoli strumenti utili in sviluppo:

- **1RM Calculator**: stima massimale
- **Volume Optimizer**: bilancia settimanale
- **Recovery Tracker**: monitora affaticamento
- **Meal Planner**: pianificatore AI pasti

**Community Feedback**  
Sezione per votare feature richieste:

```
┌────────────────────────────────────┐
│ 🗳️ VOTA LE PROSSIME FEATURE       │
│                                    │
│ 1. Dark/Light Mode Toggle          │
│    ⬆️ 1,234 voti                   │
│                                    │
│ 2. Export Progressi PDF            │
│    ⬆️ 892 voti                     │
│                                    │
│ 3. Integrazione Apple Health       │
│    ⬆️ 756 voti                     │
│                                    │
│ [ Proponi Feature ]                │
└────────────────────────────────────┘
```

### Animazioni e Transizioni

Gli elementi WIP hanno animazioni più elaborate:

- **Shimmer effect**: su card beta in caricamento
- **Particle effects**: intorno a icone "coming soon"
- **Glitch effect**: sottile su testo "experimental"
- **Neon glow**: pulsante su hover più intenso

---

## 🎓 COACH — "Professional Networking Hub"

### Filosofia della Sezione

Coach è dove la tecnologia incontra l'elemento umano: qui l'utente trova, valuta e collabora con **professionisti
certificati**. Il design deve ispirare fiducia, trasmettere competenza e facilitare connessioni autentiche.

### Struttura Principale

**Tabs Navigazione Top**

```
[ 🔍 Cerca ]  [ 💬 Chat ]  [ 👤 I Miei Coach ]
```

### Tab: Cerca Coach

**Search Bar Intelligente**  
Header persistente con ricerca avanzata:

```
┌──────────────────────────────────────┐
│ 🔍 Cerca coach per nome, sport...   │
├──────────────────────────────────────┤
│ [📍] Vicino a te    [🌐] Online     │
│ [🏋️] Specializzazione  [💰] Budget │
└──────────────────────────────────────┘
```

**Filters Modal**  
Toccando un filtro chip, si apre modal dettagliata:

**Filtro Specializzazione**:

```
☑️ Bodybuilding
☑️ Powerlifting  
☐ Calisthenics
☐ Functional
☐ Endurance
☐ Sport Specifico
```

**Filtro Budget**:

- Slider range (€0 - €200/mese)
- Toggle "Consulenza gratuita disponibile"

**Filtro Certificazioni**:

- ISSA Certified
- NASM Certified
- Laurea Scienze Motorie
- Esperienza Agonistica

**Risultati Ricerca**  
Lista verticale di coach card:

```
┌────────────────────────────────────────┐
│ ┌────┐                                 │
│ │    │ Coach Luca Bianchi              │
│ │ 📷 │ ⭐⭐⭐⭐⭐ 4.9 (234)            │
│ │    │                                 │
│ └────┘ Bodybuilding • 8 anni esp.      │
│                                        │
│ "Specializzato in ipertrofia e prep    │
│  agonistiche. Approccio scientifico."  │
│                                        │
│ 📍 Milano • 💬 Risponde in <1h         │
│ 💰 €80/mese                            │
│                                        │
│ [ 👁️ Profilo ]  [ 💬 Contatta ]       │
└────────────────────────────────────────┘
```

**Design Card Coach**:

- **Foto**: 80x80px, forma cerchio, border con badge certificazione
- **Nome**: Poppins SemiBold 18px
- **Rating**: stelle filled + numero recensioni
- **Specializzazioni**: chips colorati
- **Bio**: max 2 righe, espandibile
- **Metadata**: icone info rapide
- **CTAs**: 2 pulsanti inline

**Mappa Interattiva**  
Toggle view tra Lista e Mappa:

- Mappa con pin coach
- Tap su pin: mini-card popup
- Filtri applicati anche su mappa

### Tab: Chat

Lista conversazioni con coach:

```
┌──────────────────────────────────────┐
│ ┌───┐ Coach Luca                  🟢 │ <- Online indicator
│ │ 📷│ "Ottimo lavoro oggi!"           │
│ └───┘ 2 min fa                    [1]│ <- Badge unread
├──────────────────────────────────────┤
│ ┌───┐ Coach Maria                    │
│ │ 📷│ "Pronto per domani?"            │
│ └───┘ 1 ora fa                        │
└──────────────────────────────────────┘
```

**Chat Interface**  
Tap su conversazione apre chat fullscreen:

**Layout Chat**:

- **Header**: foto + nome coach + status online
- **Messages area**: bubble chat standard
    - Coach bubbles: align left, blu chiaro
    - User bubbles: align right, viola
- **Input bar**: text input + voice + allegati + emoji
- **Quick replies AI**: suggerimenti risposta rapida

**Features Chat Avanzate**:

- **Voice messages**: hold to record, swipe cancel
- **Media sharing**: foto esercizi, video form
- **Workout sharing**: condividi scheda direttamente
- **Booking inline**: "Prenota sessione" integrato in chat

### Tab: I Miei Coach

Dashboard dei coach seguiti:

```
┌────────────────────────────────────────┐
│ Coach Attivi (2)                       │
│                                        │
│ ┌──────────────────────────────────┐  │
│ │ [Photo] Coach Luca               │  │
│ │         💪 Scheda Attiva          │  │
│ │         💬 Ultima chat: oggi      │  │
│ │         📅 Check-in: tra 2 giorni │  │
│ │                                  │  │
│ │ [ Chat ] [ Schede ] [ Feedback ] │  │
│ └──────────────────────────────────┘  │
└────────────────────────────────────────┘
```

**Azioni Rapide per Coach**:

- **Chat diretta**: messaggio istantaneo
- **Vedi Schede**: tutte le schede assegnate
- **Lascia Feedback**: stelle + commento
- **Gestisci Abbonamento**: rinnovo, pausa, cancella

### Profilo Coach Dettagliato

Toccando "Profilo" su una coach card, fullscreen modal:

**Hero Section**

- **Cover image**: 16:9 con gradient overlay
- **Foto profilo**: grande 120x120px, centered
- **Nome + badge**: certificazioni visibili
- **CTA primario**: "Prenota Consulenza Gratuita"

**Tabs Profilo**

```
[ Info ] [ Recensioni ] [ Portfolio ] [ Servizi ]
```

**Tab Info**:

- Bio estesa
- Anni esperienza
- Certificazioni con icone verificate
- Specializzazioni
- Filosofia di coaching
- Successi clienti (testimonianze)

**Tab Recensioni**:

- Rating aggregato grande con breakdown stelle
- Lista recensioni con filtri (recenti / migliori)
- Ogni recensione: foto cliente + nome + stelle + testo + data

**Tab Portfolio**:

- Galleria trasformazioni clienti (prima/dopo con consenso)
- Video presentazione
- Articoli/Guide scritte
- Case studies

**Tab Servizi**:

```
┌───────────────────────────────┐
│ 📋 Piano Personalizzato       │
│ €80/mese                      │
│                               │
│ ✓ Schede personalizzate       │
│ ✓ Chat illimitata             │
│ ✓ Check-in settimanali        │
│ ✓ Analisi progressi AI        │
│                               │
│ [ Seleziona ]                 │
└───────────────────────────────┘

┌───────────────────────────────┐
│ 🎥 Consulenza Video 1-on-1    │
│ €35/sessione                  │
│                               │
│ ✓ 45 minuti video call        │
│ ✓ Analisi form esercizi       │
│ ✓ Piano sessione incluso      │
│                               │
│ [ Prenota ]                   │
└───────────────────────────────┘
```

### AI Features per Coach

**Matching Intelligente**  
L'AI suggerisce coach in base a:

- Obiettivi utente
- Preferenze allenamento
- Budget
- Personalità (dedotto da activity)

**Smart Notifications**

- "Coach Luca ha visto il tuo ultimo workout e ha lasciato un feedback"
- "Nuovo esercizio suggerito dal tuo coach"
- "Check-in settimanale disponibile"

---

## 🤖 AI INTEGRATION — "The Invisible Coach"

### Filosofia AI

L'intelligenza artificiale in Coachly è **onnipresente ma discreta**: non è una feature isolata, ma un layer che permea
ogni aspetto dell'esperienza. L'AI deve sembrare un compagno intelligente che conosce l'utente, anticipa bisogni e guida
verso risultati ottimali.

### Presenza Visiva AI

**Indicatore AI Attivo**  
Quando l'AI sta elaborando o ha insights da condividere, appare un piccolo orbe animato (32x32px) in posizioni
strategiche:

```
   ╭─────╮
   │ 🧠  │  <- Pulsazione soft
   ╰─────╯
```

- **Colore**: gradiente viola-blu
- **Animazione**: respiro continuo (scale 1.0 ↔ 1.1)
- **Glow**: alone luminoso pulsante
- **Tap**: espande insight o suggerimento

### AI Touchpoints

**1. Onboarding Intelligente**  
Durante la prima apertura, l'AI fa domande per profilare:

- Obiettivi fitness
- Esperienza pregressa
- Disponibilità temporale
- Eventuali limitazioni

**2. Smart Workout Builder**  
Quando l'utente crea una scheda:

```
💡 Basandomi sui tuoi obiettivi (ipertrofia)
   e sul tuo livello (intermedio), suggerisco:
   
   ▸ 4 sessioni settimanali
   ▸ Split Push/Pull/Legs/Upper
   ▸ 8-12 reps per set
   ▸ Focus compound movements
   
   [ Usa Suggerimento ] [ Personalizza ]
```

**3. Exercise Validation**  
Quando l'utente aggiunge un esercizio custom:

```
🔍 Verifico l'esercizio "Pistol Squat Jump"
   
   ✅ Esercizio valido
   📊 Difficoltà: Avanzato
   💪 Muscoli: Quadricipiti, Glutei, Core
   ⚠️ Richiede: Equilibrio, Mobilità
   
   Aggiungo al database?
   [ Sì, Aggiungi ] [ Modifica Info ]
```

**4. Form Analysis**  
Durante un workout, se l'utente carica video:

```
🎥 Analizzo la tua esecuzione...
   
   [Progress bar animata]
   
   ✅ Analisi completa
   
   ROM: 92% (Ottimo)
   Postura: Corretta
   Velocità: Controllata
   
   💡 Suggerimento: mantieni gomiti
      leggermente più vicini al corpo
      per massima attivazione tricipiti
   
   [ Vedi Dettagli ] [ Salva Report ]
```

**5. Recovery Intelligence**  
L'AI monitora segni di affaticamento:

```
⚠️ L'AI ha rilevato calo performance
   negli ultimi 3 workout
   
   Indici:
   • Volume -15% vs media
   • RPE medio +1.5
   • Qualità sonno (da smartwatch): 6.2/10
   
   Suggerimento: considera deload week
   o 2 giorni riposo completo
   
   [ Programma Recupero ] [ Ignora ]
```

**6. Predictive Suggestions**  
L'AI anticipa bisogni:

```
📅 Giovedì 18:00 - Solito orario workout

💡 Suggerisco: GAMBE & GLUTEI
   Ultima volta: 6 giorni fa (ottimale)
   Energia prevista: Alta
   Recupero: Completo
   
   [ Avvia Workout ] [ Scegli Altro ]
```

**7. Social AI Insights**  
Nella community, l'AI evidenzia contenuti rilevanti:

```
🧠 Questo post potrebbe interessarti

Coach Marco ha condiviso una guida
su "Progressione Panca Piana" basata
sui tuoi recenti workout e obiettivi

[ Leggi Post ]
```

### AI Personality

L'AI ha un tono **motivante ma realistico**:

- Mai eccessivamente entusiasta (no "AMAZING!!!")
- Riconosce sforzi e progressi con misura
- Onesta su aree di miglioramento
- Scientifica ma comprensibile
- Personalizzata (usa il nome utente)

**Esempi Tono AI**:
❌ "WOOOW! SEI INCREDIBILE!!!"
✅ "Ottimo lavoro, Marco. +5kg sulla panca rispetto a 2 settimane fa."

❌ "Sei pigro, devi allenarti di più"  
✅ "Ho notato 2 settimane di pausa. Ricominciamo gradualmente?"

❌ "Errore tecnico rilevato"
✅ "Suggerimento: prova ad abbassare il bilanciere più lentamente per massimizzare la fase eccentrica"

### AI Data Visualization

Quando l'AI presenta dati, usa visualizzazioni chiare:

**Radar Chart Muscolare**:

```
      Petto
        △
       / \
Spalle/   \Tricipiti
     /     \
    /   ●   \
   /_________\
Dorso       Bicipiti
```

- Ogni vertice rappresenta gruppo muscolare
- Area colorata mostra bilanciamento
- AI evidenzia asimmetrie

**Progress Timeline**:

```
Gen  Feb  Mar  Apr  Mag
 │    │    │    │    │
 ●────●────●────●────●───▶
 │    │    │    │    │
70kg 75kg 80kg 85kg 90kg
     │         │
     └─────────┘
     AI identifica
     fase crescita
```

**Heatmap Settimanale**:

```
L  M  M  G  V  S  D
██ ██ ░░ ██ ██ ░░ ░░
```

- Giorni workout: filled
- Riposo: empty
- AI suggerisce pattern ottimale

### AI Settings

Nella sezione Impostazioni, l'utente può configurare AI:

```
┌─────────────────────────────────┐
│ 🧠 Impostazioni AI              │
│                                 │
│ Livello Suggerimenti            │
│ ○ Minimal  ● Bilanciato  ○ Max │
│                                 │
│ Notifiche AI                    │
│ ☑️ Suggerimenti workout         │
│ ☑️ Alert recupero               │
│                                 │
│ Privacy AI                      │
│ ☑️ Analisi locale (più veloce)  │
│ ☐ Analisi cloud (più accurata)  │
│                                 │
│ [ Reset AI Preferences ]        │
└─────────────────────────────────┘
```

---

## 🎨 Componenti Riusabili

### Button System

**Primary Button**

```
┌──────────────────────┐
│   Inizia Workout     │ <- Text: Poppins Medium 16px
└──────────────────────┘
```

- **Background**: gradient blu (#0066FF → #00A3FF)
- **Height**: 48px
- **Border-radius**: 12px
- **Shadow**: 0 4px 12px rgba(0,102,255,0.3)
- **Hover**: scale 1.02 + glow intenso
- **Pressed**: scale 0.98
- **Disabled**: opacity 0.5, no interaction

**Secondary Button**

- **Background**: trasparente
- **Border**: 2px solid rgba(255,255,255,0.2)
- **Text color**: bianco
- **Hover**: background rgba(255,255,255,0.1)

**Ghost Button**

- **Background**: nessuno
- **Text color**: accent
- **Hover**: underline

### Input Fields

**Text Input**

```
┌──────────────────────────────────┐
│ 🔍  Cerca esercizi...            │
└──────────────────────────────────┘
```

- **Background**: rgba(255,255,255,0.05)
- **Border**: 1px solid rgba(255,255,255,0.1)
- **Border-radius**: 12px
- **Padding**: 12px 16px
- **Focused**: border accent color, glow
- **Icon left**: 20px left, opacity 0.6

**Number Stepper**

```
┌─────────────────────┐
│  [-]  [ 10 ]  [+]   │
└─────────────────────┘
```

- **Buttons**: 36x36px circles
- **Number**: Roboto Mono 18px, center
- **Tap**: haptic feedback
- **Long press**: increment rapido

### Cards

**Standard Card**

- **Background**: #1A1A24
- **Border-radius**: 16px
- **Padding**: 16px
- **Shadow**: 0 2px 12px rgba(0,0,0,0.2)
- **Hover**: lift effect (translateY -2px)

**Elevated Card**

- Stessa base card
- **Shadow**: 0 8px 24px rgba(0,0,0,0.3)
- **Border**: 1px solid rgba(255,255,255,0.05)

**AI Card**

- **Background**: gradient viola-blu
- **Border**: 1px glow animato
- **Icon badge**: 🧠 top-left corner

### Modals

**Bottom Sheet**

- **Background**: blur backdrop + dark overlay
- **Sheet**: slide from bottom
- **Border-radius**: 24px top corners
- **Handle**: drag indicator 40px width, 4px height, centered top
- **Dismiss**: swipe down, tap backdrop, o close button

**Fullscreen Modal**

- **Transition**: fade + scale up from center
- **Close button**: X top-right, 44x44px tap area
- **Content**: scroll se necessario

### Loading States

**Shimmer Placeholder**

- **Base**: gradient grigio animato
- **Animation**: slide left-right continuo
- **Shape**: replica contenuto reale

**Spinner**

- **Style**: circular, 24px o 48px
- **Color**: accent gradient
- **Animation**: rotate continuo smooth

**Progress Bar**

- **Height**: 4px o 8px
- **Background**: rgba(255,255,255,0.1)
- **Fill**: gradient colorato
- **Animation**: fill smooth con easing

### Empty States

Quando una sezione è vuota:

```
┌────────────────────────────────┐
│                                │
│        [Icona 64x64]           │
│                                │
│   Nessuna scheda ancora        │
│                                │
│   Crea la tua prima scheda     │
│   per iniziare ad allenarti    │
│                                │
│   [ Crea Scheda ]              │
│                                │
└────────────────────────────────┘
```

- **Illustrazione**: icona o illustrazione subtle
- **Titolo**: Poppins Medium 18px
- **Descrizione**: Inter Regular 14px, opacity 0.7
- **CTA**: primary button

### Toasts & Snackbars

**Success Toast**

```
┌──────────────────────────────┐
│ ✅ Serie completata!         │
└──────────────────────────────┘
```

- **Position**: bottom, 16px margin
- **Background**: rgba(16,185,129,0.9) blur
- **Duration**: 3s auto-dismiss
- **Animation**: slide up + fade

**Error Toast**

- **Background**: rgba(239,68,68,0.9)
- **Icon**: ❌
- **Duration**: 5s (più lungo per leggere errore)

---

## ✨ Microinterazioni e Feedback

### Haptic Feedback

**Quando usarlo**:

- Tap su pulsanti importanti (CTA, save, delete)
- Completamento azioni (serie completata, workout finito)
- Errori (input invalido)
- Navigazione tra tab
- Drag & drop
- Long press

**Intensità**:

- **Light**: navigazione, selezioni
- **Medium**: azioni positive (save, complete)
- **Heavy**: azioni critiche (delete), errori, celebrazioni

### Visual Feedback

**Button Press**

- Scale 0.95 + opacity 0.8 per 100ms
- Glow reduction durante press

**Swipe Actions**

- Card segue dito con threshold
- Icone rivelate fade-in progressivo
- Haptic al raggiungimento threshold

**Pull to Refresh**

- Indicatore custom (spinner con logo)
- Threshold 80px
- Animazione "release" elastica

**Success Actions**

- Check icon animato (stroke draw)
- Particle burst verde
- Micro-bounce element

**Error States**

- Shake animation (translate X: -10px, 10px, -10px, 0)
- Border flash rosso
- Error message slide-in

### Loading Animations

**Initial Load**

- Splash screen con logo animato
- Fade to main content

**Content Load**

- Shimmer placeholders
- Stagger animations per liste
- Skeleton screens

**Action Processing**

- Button spinner inline
- Disabled state durante process
- Success state al completamento

---

## ♿ Accessibilità

### Contrasto Colori

Tutti i testi rispettano **WCAG 2.1 Level AA**:

- Testi grandi (≥18px): contrasto ≥3:1
- Testi normali: contrasto ≥4.5:1
- Componenti UI: contrasto ≥3:1

### Font Size

**Supporto Dynamic Type**:

- Minimo: 12px
- Default: 14-16px body
- Massimo: fino a 200% scaling
- Layout responsive a scaling

### Touch Targets

**Dimensioni minime**:

- Pulsanti: 44x44px (Apple), 48x48dp (Material)
- Tap area sempre ≥44px anche se elemento visivo più piccolo
- Spaziatura tra elementi: ≥8px

### Screen Reader

**Semantic HTML/Widgets**:

- Labels descrittive su tutti input
- Heading hierarchy corretta
- Alt text su immagini significative
- ARIA labels dove necessario

**Annunci Vocali**:

- Navigazione tra sezioni annunciata
- Azioni completate confermate
- Errori letti chiaramente
- Loading states comunicati

### Motion & Animations

**Respect Reduce Motion**:

- Se utente ha "Reduce Motion" attivo:
    - Disabilitare animazioni decorative
    - Mantenere solo transizioni essenziali
    - Durata ridotta (≤200ms)
    - No parallax, no auto-play video

---

## 📱 Responsive & Adaptive Design

### Breakpoints

**Small Phones** (< 360px width):

- Layout single column
- Font size leggermente ridotto
- Bottom bar icone più compatte

**Standard Phones** (360-430px):

- Layout ottimale predefinito
- Tutte le features disponibili

**Large Phones / Phablets** (> 430px):

- Più contenuto visibile
- Card più larghe
- Possibilità layout two-column in landscape

### Orientation

**Portrait** (default):

- Bottom navigation
- Scroll verticale
- Cards stacked

**Landscape**:

- Video/media fullscreen ottimizzati
- Workout view: split screen (video | controls)
- Bottom bar rimane se altezza > 400px

### Dark/Light Mode

**Implementazione Futura**:
Attualmente app è dark-first, ma preparata per light mode:

- Variabili colore centralized
- Palette invertita già definita
- Toggle in Settings

---

## 🎬 Animation Library

### Entrance Animations

**Fade In**

- Opacity: 0 → 1
- Duration: 300ms
- Easing: ease-out

**Slide Up**

- TranslateY: 20px → 0
- Opacity: 0 → 1
- Duration: 400ms
- Easing: cubic-bezier(0.25, 0.1, 0.25, 1)

**Scale In**

- Scale: 0.8 → 1.0
- Opacity: 0 → 1
- Duration: 300ms
- Easing: ease-out

**Stagger List**

- Ogni item: delay incrementale +50ms
- Max delay: 300ms (poi tutti together)

### Exit Animations

**Fade Out**

- Opacity: 1 → 0
- Duration: 200ms
- Easing: ease-in

**Slide Down**

- TranslateY: 0 → 20px
- Opacity: 1 → 0
- Duration: 300ms

### Interaction Animations

**Button Press**

- Scale: 1.0 → 0.95 → 1.0
- Duration: 100ms press, 100ms release
- Easing: ease-in-out

**Ripple Effect**

- Circle expand from touch point
- Opacity: 0.3 → 0
- Duration: 600ms
- Easing: ease-out

**Bounce**

- Scale: 1.0 → 1.1 → 0.95 → 1.05 → 1.0
- Duration: 400ms
- Easing: cubic-bezier(0.68, -0.55, 0.265, 1.55)

### Celebration Animations

**Success Check**

- Stroke draw animation
- Duration: 600ms
- Scale bounce finale

**Particle Burst**

- 8-12 particelle from center
- Velocità random
- Fade out durante movimento
- Duration: 1200ms

**Level Up**

- Scale pulse 1.0 → 1.3 → 1.0
- Rotation 0 → 360°
- Glow intensification
- Duration: 1000ms

---

## 🎯 Riferimenti e Ispirazione

### Design Systems

**Studiare per inspirazione** (non copiare):

- **Apple Human Interface Guidelines**: standard iOS, transizioni, gestures
- **Material Design 3**: component patterns, elevation, motion
- **Nike Training Club**: energy, motivation, workout UX
- **Strava**: social features, activity feed, stats visualization
- **Fitbod**: AI workout building, clean exercise library

### Apps di Riferimento

**Liftoff** (nostro benchmark diretto):

- ✅ Clean UI, focus su tracking
- ✅ Rank system visibile
- ❌ Manca AI profonda
- ❌ Community basic
- **Cosa possiamo fare meglio**: AI proattiva, coach integration, visual richness

**Freeletics**:

- ✅ Motivational messaging
- ✅ Video exercises
- ❌ No coach human connection
- ❌ Limitato a bodyweight
- **Cosa possiamo fare meglio**: coach reali, equipment variety, community depth

### Mood e Tone

**Visual Mood**:

- Energia contenuta (non urlata)
- Tecnologia che serve l'umano
- Precisione scientifica accessibile
- Celebrazione dei piccoli progressi
- Dark elegante, non depresso

**Emotional Goals**:

- **Fiducia**: "Questo sistema sa cosa fa"
- **Motivazione**: "Voglio tornare domani"
- **Orgoglio**: "Guarda quanto sono cresciuto"
- **Connessione**: "Non sono solo in questo"
- **Efficienza**: "Ho risparmiato tempo e ottenuto risultati"

---

## 🚀 Implementazione e Handoff

### Asset Requirements

**Icone**:

- Formato: SVG vettoriale
- Sizes: 24px, 32px, 48px
- Varianti: outline, filled
- Export: @1x, @2x, @3x per iOS

**Immagini**:

- Formato: WebP (fallback JPG)
- Compressione: lossy 80-90%
- Responsive: multiple resolutions
- Lazy loading ready

**Fonts**:

- Poppins: Regular, Medium, SemiBold, Bold
- Inter: Regular, Medium
- SF Mono/Roboto Mono: Medium
- Format: TTF o OTF, font subsetting

**Animazioni**:

- Lottie JSON per animazioni complesse
- CSS/Flutter animations per micro-interactions
- Video: MP4 h.264, max 10s loops

### Design Tokens

Fornire file con variabili centralizzate:

```json
{
  "colors": {
    "primary": "#0066FF",
    "secondary": "#8B5CF6",
    "success": "#10B981",
    "warning": "#F59E0B",
    "error": "#EF4444",
    "background": "#0A0A0F",
    "surface": "#1A1A24"
  },
  "spacing": {
    "xs": 4,
    "sm": 8,
    "md": 16,
    "lg": 24,
    "xl": 32
  },
  "borderRadius": {
    "sm": 8,
    "md": 12,
    "lg": 16,
    "xl": 24,
    "full": 9999
  }
}
```

### Figma/Design Files

**Struttura consigliata**:

```
Coachly Design System
├── 🎨 Brand
│   ├── Logo
│   ├── Colors
│   └── Typography
├── 🧩 Components
│   ├── Buttons
│   ├── Inputs
│   ├── Cards
│   └── Modals
├── 📱 Screens
│   ├── Community
│   ├── Workouts
│   ├── Home
│   ├── WIP
│   └── Coach
└── 🎬 Prototypes
    ├── Onboarding Flow
    ├── Workout Flow
    └── Coach Search Flow
```

**Annotations**:

- Stati: default, hover, pressed, disabled
- Spacing: indicare margin/padding
- Breakpoints: indicare se adaptive
- Interactions: descrivere animazioni

---

## ✅ Checklist Finale

Prima di iniziare l'implementazione, verificare:

**Visual Design**:

- [ ] Palette colori definita e approvata
- [ ] Tipografia scelta e font files pronti
- [ ] Iconografia completa per tutte le sezioni
- [ ] Animazioni documentate con timing

**UI Components**:

- [ ] Button variants (primary, secondary, ghost)
- [ ] Input fields (text, number, search)
- [ ] Cards (standard, elevated, AI)
- [ ] Modals (bottom sheet, fullscreen)
- [ ] Loading states (spinner, shimmer, progress)
- [ ] Empty states per ogni sezione

**Schermate**:

- [ ] Community: feed, stories, post details
- [ ] Workouts: home, scheda detail, esercizio detail, active workout
- [ ] Home: dashboard personalizzata
- [ ] WIP: beta features, coming soon
- [ ] Coach: search, chat, profile detail

**AI Elements**:

- [ ] AI indicator visuals
- [ ] AI card design
- [ ] Suggestion cards
- [ ] Analysis results layouts

**Interactions**:

- [ ] Navigation transitions definite
- [ ] Gesture controls documentati
- [ ] Feedback haptic mappato
- [ ] Loading states per action

**Accessibilità**:

- [ ] Contrast ratios verificati
- [ ] Touch targets ≥44px
- [ ] Screen reader labels
- [ ] Reduce motion alternative

---

## 📞 Contatti e Feedback

Questo documento è vivo e si evolverà con il progetto. Per domande, chiarimenti o proposte di miglioramento:

**Design Lead**: [Nome]  
**Email**: design@coachly.com  
**Figma**: [Link workspace]  
**Feedback**: [Form o canale dedicato]

---

**Versione**: 1.0  
**Data**: Ottobre 2024  
**Status**: Ready for Implementation

---

*Coachly - Design System*  
*"Where AI meets Human Performance"* 🏋️‍♂️🧠