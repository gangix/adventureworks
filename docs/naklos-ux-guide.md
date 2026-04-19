# Naklos.com.tr — UX/UI İyileştirme Rehberi
### Filo Yönetimi İçin Modern, Verimli ve Hoş Bir Arayüz Tasarlama Kılavuzu

> **Sürüm:** 1.0 · **Tarih:** Nisan 2026 · **Hedef Kitle:** Ürün ekibi, geliştiriciler, tasarımcılar  
> **Dil:** 🇹🇷 Türkçe · **Format:** Markdown + Tailwind/React örnekler

---

## İçindekiler

1. [Yönetici Özeti (TL;DR)](#1-yönetici-özeti)
2. [Mevcut Durum Analizi](#2-mevcut-durum-analizi)
3. [Tasarım Prensipleri & Görsel Sistem Yenileme](#3-tasarım-prensipleri)
4. [Ekran-Bazında İyileştirmeler](#4-ekran-bazında-i̇yileştirmeler)
5. [İş Akışı Verimliliği](#5-iş-akışı-verimliliği)
6. [Mobil & Responsive Deneyim](#6-mobil--responsive-deneyim)
7. [Erişilebilirlik (a11y) Kontrol Listesi](#7-erişilebilirlik)
8. [Rakip Analizi: Samsara · Fleetio · Verizon Connect](#8-rakip-analizi)
9. [Özellik Yol Haritası: Must-Have vs Nice-to-Have](#9-özellik-yol-haritası)
10. [Uygulama Öncelik Matrisi](#10-öncelik-matrisi)
11. [Ek: Kod Bileşenleri Kütüphanesi](#11-ek-kod-bileşenleri)

---

## 1. Yönetici Özeti

Naklos, filo yöneticileri için **gerçekten ihtiyaç duyulan temel özelliklere** odaklanmış, temiz ve işlevsel bir arayüze sahip. Ancak günlük **yüksek tempolu kullanım** için bazı kritik UX eksiklikleri var. Bu rehber, uygulamanızı sektörün üst liginde (Samsara, Fleetio seviyesinde) bir ürüne dönüştürecek **somut önerileri**, **Tailwind/React kod örnekleriyle** birlikte sunar.

### 🎯 En Kritik 8 İyileştirme (bu rehberin özü)

| # | Öneri | Etki | Efor |
|---|-------|------|------|
| 1 | **Üst "Komuta Çubuğu"** (Today's Briefing) — günün özetini tek bakışta göster | ⭐⭐⭐⭐⭐ | 🔨🔨 |
| 2 | **Uyarılar için toplu işlem + akıllı filtreler** (bulk review, snooze, assign) | ⭐⭐⭐⭐⭐ | 🔨🔨 |
| 3 | **Gerçek bir Dashboard**: Trend grafikleri, maliyet kartları, sürücü skor tablosu | ⭐⭐⭐⭐⭐ | 🔨🔨🔨 |
| 4 | **Komut paleti (⌘K)** — her şeye 1 saniyede eriş | ⭐⭐⭐⭐ | 🔨🔨 |
| 5 | **Belge zaman tüneli** (document timeline) — yaklaşan sürelerin yıllık görünümü | ⭐⭐⭐⭐ | 🔨🔨 |
| 6 | **Boş durum → aksiyon köprüsü** (empty-state'leri tutorial'a dönüştür) | ⭐⭐⭐ | 🔨 |
| 7 | **Tutarlı tasarım tokenları** (renk, spacing, radius, shadow) | ⭐⭐⭐⭐ | 🔨 |
| 8 | **Mobil-öncelikli liste kartları** (şoförler sahada bu app'i görecek) | ⭐⭐⭐⭐ | 🔨🔨 |

---

## 2. Mevcut Durum Analizi

### 🏠 Ana Sayfa (Filom)

**✅ İyi olan:**
- Tarih bilgisi kullanıcıyı konumlandırıyor ("Pazar · 19 Nisan 2026")
- 3 birincil CTA (Araç Ekle / Sürücü Ekle / Yakıt İçe Aktar) net ve erişilebilir
- Araçlar/Sürücüler sayacı hızlı özet sağlıyor
- Belge detayı altta listeleniyor

**❌ Sorunlar:**
- **Filo Durumu kartları çok "statik"** — sadece sayı var, hiçbir trend veya karşılaştırma yok ("geçen haftaya göre +2")
- **"Dikkatinize Sunulan"** sadece tek satır — oysa en kritik bölüm bu olmalı
- **KPI eksik**: Toplam yakıt maliyeti, km başına maliyet, sürücü skoru, aktif/idle oranı, bu ay şüpheli dolum sayısı… hiçbiri yok
- Hiyerarşi zayıf: Belge detayı liste halinde ama **"hangi belge bugün kritik?"** anlaşılmıyor
- **Görsel tek düzen**: Kartların hepsi aynı — vurgu yapacak şey yok
- Boşluk kullanımı dengesiz — altta büyük boş alan var ama üstte sıkışık

### 🚚 Araçlar Ekranı

**✅ İyi olan:**
- Durum filtreleri (Tümü / Aktif / Hazır / Eksik belgeler) doğru IA
- Kırmızı border + uyarı etiketi belgesi eksik araçları hızlı gösteriyor
- "Berlin · 11 saat önce" konum bilgisi güzel

**❌ Sorunlar:**
- Kartlar **çok yer kaplıyor** (100 araçlık filoda scroll cehennemi)
- **Tablo/grid görünümü yok** — güçlü kullanıcılar için yoğun görünüm eksik
- **Arama/sıralama yok** (plaka, model, sürücü, konum bazında)
- Her araç için "aksiyon" yok (atama, mesaj, belge yükle → hepsi tıklayıp detaya gitme)
- **Harita görünümü yok** — konum bilgisi var ama görselleştirme yok
- Eksik belgeler listesi **sadece tekrar** ediyor ("Zorunlu sigorta belgesi eksik (34 ABC 123)") — plaka zaten başlıkta, gereksiz

### 👤 Sürücüler Ekranı

**✅ İyi olan:**
- Kart temiz, telefon numarası ve atanmış araç net
- "SRC Belgesi 10 gün içinde sona erecek" uyarısı sarı renkte → doğru

**❌ Sorunlar:**
- **Çok minimal** — sürücü skoru, sürüş davranışı, son aktivite, yakıt verimliliği yok
- **Fotoğraf/avatar yok** — insan odaklı bir modül ama insansızlaştırılmış
- Tek sürücü için bile bu kadar boşluk fazla
- Sürücüye **doğrudan mesaj gönderme / çağrı** aksiyonu yok
- Performans karşılaştırması (leaderboard) yok

### ⚠️ Yakıt Uyarıları

**✅ İyi olan:**
- 3-seviyeli önceliklendirme (Acil / Dikkat / Bilgi) — çok iyi bir pattern
- Araç bazında gruplama mantıklı
- "7 uyarı incelemeni bekliyor" başlığı aksiyonu belirtiyor
- Fiyat-miktar uyuşmazlığı gibi akıllı kurallar var

**❌ Sorunlar:**
- **Toplu işlem yok** — 100 uyarı varsa tek tek tıklanacak
- **Snooze / ertele / ata** gibi aksiyonlar yok
- **Sebep açıklaması eksik** — "Tutar ₺90,00 girilmiş; fiyat x litre = ₺180,00" iyi ama **%100 sapma** gibi yüzde gösterilmiyor
- **Pattern görünümü yok** — "34 ABC 123 bu hafta 5. kez sorun çıkarıyor" gibi uyarı kalıpları eksik
- Filtreler (Tüm araçlar, Tüm kurallar) **dropdown ama aranmıyor** — 50 araç varsa bulmak zor
- **Zaman aralığı** sabit "Son 7 gün" — özelleştirilemiyor (görünür)

### 📥 İçe Aktar

**✅ İyi olan:**
- Son içe aktarmalar listesi + durum etiketleri ("0 içe aktarıldı", "10 eşleşmedi") çok iyi
- Format seçimi ve dosya yükleme basit

**❌ Sorunlar:**
- **Şablon/örnek dosya linki yok** görünür şekilde (ilk kez kullanan ne yapacak?)
- **Drag & drop yok** (sadece "Dosya Seç" butonu)
- **"10 eşleşmedi"** → sebep ne? Tıklayınca ne olacak? Önizleme yok
- **Sütun eşleştirme (mapping) sihirbazı** görünmüyor — bu tür içe aktarmalarda olmazsa olmaz
- "Önizle" butonu edilgen görünüyor (devre dışı gibi)

---

## 3. Tasarım Prensipleri

### 3.1 Tasarım Felsefesi: "Calm but Confident"

Filo yönetimi **uzun soluklu, yorucu bir iş**. Kullanıcı günde 2-3 saat bu app'te. Bu nedenle:

- **Gürültüyü kıs**: Gereksiz ikon, gradient, gölge yok
- **Kritik olana vurgu**: Sadece **acil olanlar** dikkat çeker — geri kalan sakin
- **Tutarlı**: 4px grid, 4 renk tonu, 3 yazı tipi ağırlığı. O kadar.
- **Hızlı**: Her aksiyon ≤ 2 tıklama
- **Güven veren**: Hata mesajları, boş durumlar, loading state'ler — hepsi açık ve dostça

### 3.2 Renk Sistemi (Design Tokens)

Mevcut mavi temelli paletiniz iyi, ama **tutarlı tokenlara** ihtiyacı var. Aşağıda hem light hem dark mode destekli profesyonel bir palet:

```css
/* /app/frontend/src/index.css */
@layer base {
  :root {
    /* Neutrals — "stone" based, warmer than pure gray */
    --color-bg:          #FAFAF9;   /* page background */
    --color-surface:     #FFFFFF;   /* cards */
    --color-surface-2:   #F5F5F4;   /* subtle surfaces */
    --color-border:      #E7E5E4;
    --color-border-strong: #D6D3D1;
    
    /* Text */
    --color-text:        #0C0A09;   /* near-black */
    --color-text-muted:  #57534E;
    --color-text-subtle: #A8A29E;
    
    /* Brand (Naklos navy) */
    --color-primary:     #1E3A8A;   /* navy 800 */
    --color-primary-600: #1D4ED8;
    --color-primary-50:  #EFF6FF;
    
    /* Semantic — calibrated for WCAG AA */
    --color-danger:      #DC2626;   /* red 600 */
    --color-danger-bg:   #FEF2F2;
    --color-warning:     #D97706;   /* amber 600 — değişti, daha sıcak */
    --color-warning-bg:  #FFFBEB;
    --color-success:     #15803D;   /* green 700 */
    --color-success-bg:  #F0FDF4;
    --color-info:        #0369A1;   /* sky 700 */
    --color-info-bg:     #F0F9FF;
    
    /* Depth */
    --shadow-sm: 0 1px 2px 0 rgb(0 0 0 / 0.04);
    --shadow:    0 1px 3px 0 rgb(0 0 0 / 0.06), 0 1px 2px -1px rgb(0 0 0 / 0.04);
    --shadow-md: 0 4px 6px -1px rgb(0 0 0 / 0.08), 0 2px 4px -2px rgb(0 0 0 / 0.04);
    --shadow-lg: 0 10px 15px -3px rgb(0 0 0 / 0.08), 0 4px 6px -4px rgb(0 0 0 / 0.05);
    
    /* Radius */
    --radius-sm: 6px;
    --radius:    10px;   /* default — biraz daha yumuşak */
    --radius-lg: 14px;
    --radius-xl: 20px;
  }
  
  [data-theme="dark"] {
    --color-bg:          #0C0A09;
    --color-surface:     #1C1917;
    --color-surface-2:   #292524;
    --color-border:      #292524;
    --color-border-strong: #44403C;
    --color-text:        #FAFAF9;
    --color-text-muted:  #A8A29E;
    --color-text-subtle: #78716C;
    --color-primary:     #60A5FA;
    --color-primary-50:  #1E293B;
    --color-danger-bg:   #450A0A;
    --color-warning-bg:  #451A03;
    --color-success-bg:  #052E1A;
    --color-info-bg:     #082F49;
  }
}
```

**🎨 Neden bu palet?**
- **Stone/warm-neutral** palet saf gri yerine ürün sıcaklığını artırır (finans-dışı hissi)
- **Navy primary** — Naklos'un mevcut karakteri korunuyor
- **Amber vs Orange warning** — Orange'ın kırmızıyla karışma riskini azaltır
- **Info mavisi primary'den farklı ton** (sky 700) → "bilgi" ile "aksiyon" karışmaz

### 3.3 Tipografi

Sektörde klasik olan **Inter** yerine biraz daha karakterli alternatifler öneriyorum:

**Seçenek A (modern & net):** `Geist` (Vercel) + `Geist Mono`  
**Seçenek B (klasik & güvenilir):** `IBM Plex Sans` + `IBM Plex Mono`  
**Seçenek C (dengeli, Türkçe karakterler güzel):** `Manrope` + `JetBrains Mono` ⭐ önerim

```html
<!-- index.html -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;600;700;800&family=JetBrains+Mono:wght@400;500&display=swap" rel="stylesheet">
```

```js
// tailwind.config.js
theme: {
  extend: {
    fontFamily: {
      sans: ['Manrope', 'ui-sans-serif', 'system-ui', '-apple-system'],
      mono: ['JetBrains Mono', 'ui-monospace', 'monospace'],
    },
    fontSize: {
      // Rakamlar için özel scale (plaka, KPI, fiyat gösterimleri)
      'kpi-sm': ['1.5rem',  { lineHeight: '1.75rem', fontWeight: '700', letterSpacing: '-0.02em' }],
      'kpi':    ['2.25rem', { lineHeight: '2.5rem',  fontWeight: '700', letterSpacing: '-0.025em' }],
      'kpi-lg': ['3rem',    { lineHeight: '3.25rem', fontWeight: '800', letterSpacing: '-0.03em' }],
    },
  }
}
```

**📏 Tipografi skala kuralı:**
```
H1 (sayfa başlığı):      32px / 700 / -0.02em
H2 (bölüm başlığı):      22px / 700
H3 (kart başlığı):       16px / 600
Body:                    14px / 400
Caption / meta:          12px / 500 / uppercase (tracking +0.05em)
KPI rakamlar:            monospace + tabular-nums (hizalama için!)
Plaka numaraları:        monospace + tracking +0.02em
```

> 💡 **Pro ipucu:** Rakamlar için mutlaka `font-variant-numeric: tabular-nums` kullanın. Tablolarda sayılar hizalanır. Tailwind'de: `class="tabular-nums"`.

### 3.4 Boşluk & Grid

```js
// tailwind.config.js — özel spacing tokenları
spacing: {
  'page-x':  '1.5rem',   // mobil padding
  'page-lg': '2.5rem',   // desktop padding  
  'section': '3rem',     // bölümler arası
  'card-p':  '1.25rem',  // kart iç padding standart
}
```

**Kural:** 8-point grid. Her şey `4, 8, 12, 16, 20, 24, 32, 40, 48, 64` px'in katı olsun. Keyfi `15px` yok.

### 3.5 İkonografi

**Lucide React** zaten kurulu — harika bir seçim. Mevcut ikonları şu set'e göre standardize edin:

| Kavram | İkon | Kullanım |
|--------|------|----------|
| Araç | `Truck` | nav, araç kartları |
| Sürücü | `Users` (grup) / `User` (tek) | nav, sürücü kartları |
| Yakıt | `Fuel` | nav, yakıt sayfası |
| Uyarı (acil) | `AlertOctagon` | kırmızı seviye |
| Uyarı (dikkat) | `AlertTriangle` | turuncu/amber seviye |
| Bilgi | `Info` | mavi seviye |
| Başarılı | `CheckCircle2` | doğrulama |
| Belge | `FileText` | belge bekleyenler |
| Belge eksik | `FileX` | kırmızı işaretli |
| Tarih/süre | `Clock` / `CalendarClock` | kalan gün göstergesi |
| Konum | `MapPin` | canlı konum |
| Ayarlar | `Settings2` (ince) | kurallar, yapılandırma |
| Filtre | `SlidersHorizontal` | filtreler |
| Arama | `Search` | arama kutusu |
| Komut paleti | `Command` | ⌘K tetikleyici |
| İçe aktar | `Upload` / `FileUp` | dosya yükleme |
| Dışa aktar | `Download` / `FileDown` | rapor indirme |
| Bildirim | `Bell` | bildirim merkezi |

**Boyut kuralı:** `h-4 w-4` (inline), `h-5 w-5` (butonlar), `h-6 w-6` (nav), `h-10 w-10` (büyük vurgu).

### 3.6 Motion (Mikro-animasyonlar)

Framer Motion zaten destekleniyor. Aşırıya kaçmadan bu 4 micro-interaction'ı ekleyin:

```jsx
// 1. Kart giriş — staggered
<motion.div
  initial={{ opacity: 0, y: 8 }}
  animate={{ opacity: 1, y: 0 }}
  transition={{ duration: 0.3, delay: index * 0.04, ease: [0.22, 1, 0.36, 1] }}
>

// 2. Sayı artışı (KPI'ler için)
import { useSpring, animated } from '@react-spring/web';
const { n } = useSpring({ from: { n: 0 }, n: value, config: { duration: 800 } });
<animated.span>{n.to(x => Math.floor(x).toLocaleString('tr-TR'))}</animated.span>

// 3. Uyarı pulsar (yeni kritik uyarı geldiğinde)
<span className="relative inline-flex">
  <span className="absolute inline-flex h-full w-full animate-ping rounded-full bg-red-400 opacity-75" />
  <span className="relative inline-flex h-2 w-2 rounded-full bg-red-600" />
</span>

// 4. Hover-lift (tıklanabilir kartlar)
className="transition-all duration-200 hover:-translate-y-0.5 hover:shadow-md"
```

**Kural:** `transition: all` KULLANMAYIN — sadece ilgili property'leri belirtin (`transition-colors`, `transition-transform`). `all` transform bozar, performansı düşürür.
---

## 4. Ekran-Bazında İyileştirmeler

### 4.1 🏠 Ana Sayfa — "Komut Merkezi" Olarak Yeniden Düşünme

Filo yöneticisinin sabah ilk açtığı ekran → **günün brifingi** olmalı. Mevcut "Filom" ekranı bir sayaç listesi, bizim gerçek bir **dashboard**'a ihtiyacımız var.

#### Yeni yapı (yukarıdan aşağıya):

```
┌─────────────────────────────────────────────────────────────┐
│  Merhaba Ahmet · Pazar 19 Nisan           [⌘ K Arama] [🌙]  │
│  ┌───────────────────────────────────────────────────────┐  │
│  │ 🟠 Bugün 7 uyarı incelemen gerekiyor — 1'i acil        │  │
│  │    [Uyarılara Git →]      [Hepsini Erteleyi Planla]    │  │
│  └───────────────────────────────────────────────────────┘  │
│                                                              │
│  ═══ BUGÜNÜN RESMİ ═══════════════════════════════════       │
│  ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐       │
│  │ Aktif    │ │ Bu ay    │ │ km başı  │ │ Şüpheli  │       │
│  │ Filo     │ │ yakıt    │ │ maliyet  │ │ dolum    │       │
│  │ 2/3 🟢   │ │ ₺12.480  │ │ ₺3.21    │ │  1 🔴    │       │
│  │ %66      │ │ ↓ %8     │ │ ↑ %4     │ │ bu hafta │       │
│  └──────────┘ └──────────┘ └──────────┘ └──────────┘       │
│                                                              │
│  ═══ BELGE ZAMAN ÇİZELGESİ (90 gün) ═══                     │
│  [sparkline — her hafta kaç belge bitiyor]                  │
│  ● 10g SRC · joe doe                                         │
│  ● 18g Muayene · 34 ABC 123                                  │
│  ● 24g Sigorta · 07 QRS 300                                  │
│                                                              │
│  ═══ FİLO HARİTASI (canlı) ═══  ═══ SÜRÜCÜ LEADERBOARD ═══  │
│  [mini mapbox/leaflet]          1. Mehmet ─ 92 skor          │
│                                 2. Ayşe  ─ 88                │
└─────────────────────────────────────────────────────────────┘
```

#### Uygulama: "Komuta Çubuğu" bileşeni

```jsx
// /app/frontend/src/components/dashboard/CommandBar.jsx
import { AlertTriangle, ChevronRight, Snowflake } from 'lucide-react';
import { motion } from 'framer-motion';

export function CommandBar({ urgentCount, attentionCount, infoCount }) {
  const total = urgentCount + attentionCount + infoCount;
  if (total === 0) return <AllClearBanner />;
  
  const severity = urgentCount > 0 ? 'urgent' : 'attention';
  const styles = {
    urgent:    'border-red-200 bg-red-50 text-red-900',
    attention: 'border-amber-200 bg-amber-50 text-amber-900',
  };
  
  return (
    <motion.div
      initial={{ opacity: 0, y: -8 }}
      animate={{ opacity: 1, y: 0 }}
      className={`flex items-center justify-between gap-4 rounded-xl border ${styles[severity]} px-5 py-4`}
      data-testid="command-bar"
    >
      <div className="flex items-center gap-3">
        <span className="relative flex h-3 w-3">
          {urgentCount > 0 && (
            <span className="absolute inline-flex h-full w-full animate-ping rounded-full bg-red-400 opacity-75" />
          )}
          <span className={`relative inline-flex h-3 w-3 rounded-full ${
            urgentCount > 0 ? 'bg-red-600' : 'bg-amber-500'
          }`} />
        </span>
        <div>
          <p className="font-semibold">
            Bugün <span className="tabular-nums">{total}</span> uyarı incelemen gerekiyor
            {urgentCount > 0 && (
              <span className="ml-1">— <span className="tabular-nums">{urgentCount}</span>'i acil</span>
            )}
          </p>
          <p className="text-xs opacity-70 mt-0.5">
            {attentionCount} dikkat · {infoCount} bilgi · son 7 gün
          </p>
        </div>
      </div>
      
      <div className="flex items-center gap-2">
        <button 
          data-testid="cmdbar-snooze-btn"
          className="inline-flex items-center gap-1.5 rounded-lg border border-current/20 bg-white/50 px-3 py-1.5 text-sm font-medium hover:bg-white transition-colors">
          <Snowflake className="h-4 w-4" /> Yarına Ertele
        </button>
        <button 
          data-testid="cmdbar-alerts-btn"
          className="inline-flex items-center gap-1.5 rounded-lg bg-current px-3 py-1.5 text-sm font-medium text-white hover:opacity-90 transition-opacity">
          <span className="text-white">Uyarılara Git</span>
          <ChevronRight className="h-4 w-4 text-white" />
        </button>
      </div>
    </motion.div>
  );
}

function AllClearBanner() {
  return (
    <div className="flex items-center gap-3 rounded-xl border border-emerald-200 bg-emerald-50 px-5 py-4 text-emerald-900">
      <span className="inline-flex h-3 w-3 rounded-full bg-emerald-500" />
      <p className="font-semibold">Tüm sistemler sakin 🌤️ — bugün aksiyon bekleyen bir şey yok.</p>
    </div>
  );
}
```

#### Uygulama: KPI Kartı — trend + sparkline ile

```jsx
// /app/frontend/src/components/dashboard/KpiCard.jsx
import { TrendingUp, TrendingDown, Minus } from 'lucide-react';

export function KpiCard({ label, value, unit, delta, deltaLabel, spark, tone = 'neutral', testId }) {
  // tone: 'neutral' | 'good' | 'bad'
  const trendColor = {
    good: 'text-emerald-600 bg-emerald-50',
    bad:  'text-red-600 bg-red-50',
    neutral: 'text-stone-600 bg-stone-100',
  }[tone];
  
  const TrendIcon = delta > 0 ? TrendingUp : delta < 0 ? TrendingDown : Minus;
  
  return (
    <div 
      data-testid={testId}
      className="group relative overflow-hidden rounded-xl border border-stone-200 bg-white p-5 transition-all hover:border-stone-300 hover:shadow-sm"
    >
      <p className="text-xs font-medium uppercase tracking-wider text-stone-500">{label}</p>
      
      <div className="mt-2 flex items-baseline gap-1.5">
        <span className="font-display text-3xl font-bold tabular-nums tracking-tight text-stone-900">
          {value}
        </span>
        {unit && <span className="text-sm font-medium text-stone-500">{unit}</span>}
      </div>
      
      {typeof delta === 'number' && (
        <div className={`mt-2 inline-flex items-center gap-1 rounded-md px-1.5 py-0.5 text-xs font-medium ${trendColor}`}>
          <TrendIcon className="h-3 w-3" />
          <span className="tabular-nums">{Math.abs(delta)}%</span>
          <span className="opacity-60">{deltaLabel}</span>
        </div>
      )}
      
      {spark && (
        <div className="absolute inset-x-0 bottom-0 h-12 opacity-40 group-hover:opacity-70 transition-opacity">
          <Sparkline data={spark} />
        </div>
      )}
    </div>
  );
}

// Basit SVG sparkline (recharts istemezseniz)
function Sparkline({ data }) {
  const max = Math.max(...data);
  const min = Math.min(...data);
  const path = data
    .map((v, i) => `${(i / (data.length - 1)) * 100},${100 - ((v - min) / (max - min || 1)) * 100}`)
    .join(' L ');
  return (
    <svg viewBox="0 0 100 100" preserveAspectRatio="none" className="h-full w-full">
      <path d={`M ${path}`} fill="none" stroke="currentColor" strokeWidth="1.5" className="text-stone-400" />
    </svg>
  );
}
```

#### Uygulama örneği:

```jsx
<div className="grid grid-cols-2 gap-4 lg:grid-cols-4">
  <KpiCard label="Aktif Filo"   value="2/3"    unit="araç"    testId="kpi-active-fleet" />
  <KpiCard label="Bu Ay Yakıt"  value="12.480" unit="₺"       delta={-8} deltaLabel="önceki ay"
           tone="good" spark={[10,12,9,11,13,10,8,9]} testId="kpi-fuel-cost" />
  <KpiCard label="km başı"      value="3.21"   unit="₺/km"    delta={4}  deltaLabel="önceki ay"
           tone="bad"  testId="kpi-cost-per-km" />
  <KpiCard label="Şüpheli Dolum" value="1"     unit="bu hafta" tone="bad" testId="kpi-suspicious" />
</div>
```

### 4.2 🚚 Araçlar Ekranı — Yoğun Kullanıcı İçin Güç

#### İyileştirmeler:

**1. Görünüm geçişi (Liste ↔ Tablo ↔ Harita)**

```jsx
// Üstte toggle group
<ViewToggle
  options={[
    { id: 'list',  icon: LayoutList,    label: 'Liste' },
    { id: 'table', icon: Rows3,         label: 'Tablo' },
    { id: 'map',   icon: Map,           label: 'Harita' },
  ]}
  value={view}
  onChange={setView}
  data-testid="vehicles-view-toggle"
/>
```

**2. Gelişmiş arama + filtre barı**

```jsx
<div className="flex flex-col gap-3 sm:flex-row sm:items-center">
  <div className="relative flex-1">
    <Search className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-stone-400" />
    <input
      data-testid="vehicles-search"
      placeholder="Plaka, marka, sürücü, konum ara… (⌘K)"
      className="w-full rounded-lg border border-stone-200 bg-white py-2 pl-10 pr-3 text-sm placeholder:text-stone-400 focus:border-indigo-500 focus:outline-none focus:ring-2 focus:ring-indigo-500/20"
    />
  </div>
  
  <FilterChip label="Durum" options={[...]} data-testid="filter-status" />
  <FilterChip label="Tip"   options={['TIR','Kamyon','Frigorifik']} />
  <FilterChip label="Şehir" options={[...]} />
  <button data-testid="clear-filters-btn" className="text-sm text-stone-500 hover:text-stone-700">
    Filtreleri Temizle
  </button>
</div>
```

**3. Kompakt satır tasarımı (tablo görünümü)**

```jsx
<table className="w-full text-sm">
  <thead className="border-b border-stone-200 bg-stone-50/50">
    <tr className="text-xs font-semibold uppercase tracking-wide text-stone-500">
      <th className="py-2.5 px-4 text-left">Plaka</th>
      <th className="py-2.5 px-4 text-left">Tip</th>
      <th className="py-2.5 px-4 text-left">Sürücü</th>
      <th className="py-2.5 px-4 text-left">Son Konum</th>
      <th className="py-2.5 px-4 text-left">Belge Durumu</th>
      <th className="py-2.5 px-4 text-right">İşlemler</th>
    </tr>
  </thead>
  <tbody className="divide-y divide-stone-100">
    {vehicles.map(v => (
      <tr key={v.id} data-testid={`vehicle-row-${v.plate}`}
          className="group hover:bg-stone-50 transition-colors">
        <td className="py-3 px-4 font-mono font-medium tracking-wide">{v.plate}</td>
        <td className="py-3 px-4 text-stone-600">{v.type}</td>
        <td className="py-3 px-4">
          {v.driver ? (
            <DriverChip driver={v.driver} />
          ) : (
            <span className="text-xs text-stone-400 italic">Atanmadı</span>
          )}
        </td>
        <td className="py-3 px-4 text-stone-600 text-xs">
          {v.location} · <TimeAgo date={v.lastSeen} />
        </td>
        <td className="py-3 px-4">
          <DocStatusBadge status={v.docStatus} />
        </td>
        <td className="py-3 px-4 text-right">
          <RowActions vehicle={v} />
        </td>
      </tr>
    ))}
  </tbody>
</table>
```

**4. Hover aksiyonları**

```jsx
// Row'un sağında hover'da belirir
<div className="flex items-center justify-end gap-1 opacity-0 group-hover:opacity-100 transition-opacity">
  <IconButton icon={Eye}          tooltip="Detayları Gör" onClick={...} />
  <IconButton icon={UserPlus}     tooltip="Sürücü Ata"    onClick={...} />
  <IconButton icon={FileUp}       tooltip="Belge Yükle"   onClick={...} />
  <IconButton icon={MoreVertical} tooltip="Daha Fazla"    onClick={...} />
</div>
```

**5. "Eksik belgeler" → kompakt badge + hover-to-expand**

```jsx
// Her tekrar için uzun satır yazmak yerine:
<DocStatusBadge status="incomplete" count={2} />
// → "⚠ 2 eksik" → hover → popover açılır ve hangi 2 belge gösterir
```

### 4.3 👤 Sürücüler Ekranı — İnsansılaştırma

#### İyileştirmeler:

**1. Avatar + performans skoru**

```jsx
// /app/frontend/src/components/drivers/DriverCard.jsx
export function DriverCard({ driver }) {
  return (
    <div data-testid={`driver-card-${driver.id}`}
         className="rounded-xl border border-stone-200 bg-white p-5 hover:border-stone-300 hover:shadow-sm transition-all">
      <div className="flex items-start gap-4">
        {/* Avatar with status dot */}
        <div className="relative flex-shrink-0">
          <Avatar name={driver.name} photo={driver.photo} size="lg" />
          <StatusDot status={driver.status} className="absolute bottom-0 right-0" />
        </div>
        
        <div className="flex-1 min-w-0">
          <div className="flex items-start justify-between gap-2">
            <div>
              <h3 className="font-semibold text-stone-900">{driver.name}</h3>
              <p className="text-sm text-stone-500">{driver.phone}</p>
            </div>
            <DriverScoreBadge score={driver.score} />
          </div>
          
          <div className="mt-3 flex items-center gap-4 text-xs text-stone-500">
            <span className="inline-flex items-center gap-1">
              <Truck className="h-3.5 w-3.5" /> {driver.vehicle?.plate ?? 'Atanmadı'}
            </span>
            <span className="inline-flex items-center gap-1">
              <MapPin className="h-3.5 w-3.5" /> {driver.city}
            </span>
            <span className="inline-flex items-center gap-1">
              <Clock className="h-3.5 w-3.5" /> <TimeAgo date={driver.lastActive} />
            </span>
          </div>
        </div>
      </div>
      
      {/* Alerts (if any) */}
      {driver.alerts?.map(alert => (
        <DriverAlert key={alert.id} alert={alert} className="mt-3" />
      ))}
      
      {/* Quick actions */}
      <div className="mt-4 flex items-center gap-2 border-t border-stone-100 pt-3">
        <QuickAction icon={Phone}        label="Ara"    onClick={...} />
        <QuickAction icon={MessageSquare} label="Mesaj" onClick={...} />
        <QuickAction icon={FileText}     label="Belgeler" onClick={...} />
        <QuickAction icon={BarChart3}    label="Performans" onClick={...} className="ml-auto" />
      </div>
    </div>
  );
}

function DriverScoreBadge({ score }) {
  const { bg, text, label } = 
    score >= 90 ? { bg: 'bg-emerald-50', text: 'text-emerald-700', label: 'Mükemmel' } :
    score >= 75 ? { bg: 'bg-sky-50',     text: 'text-sky-700',     label: 'İyi' } :
    score >= 60 ? { bg: 'bg-amber-50',   text: 'text-amber-700',   label: 'Orta' } :
                  { bg: 'bg-red-50',     text: 'text-red-700',     label: 'Zayıf' };
  
  return (
    <div className={`inline-flex flex-col items-end rounded-lg ${bg} ${text} px-2.5 py-1`}>
      <span className="text-lg font-bold tabular-nums leading-none">{score}</span>
      <span className="text-[10px] font-medium uppercase tracking-wide">{label}</span>
    </div>
  );
}
```

**2. Leaderboard sekmesi**

```jsx
// Sürücüler sayfasına yeni tab: "Sıralama"
<Tabs>
  <Tab>Tümü</Tab>
  <Tab>Aktif</Tab>
  <Tab>Hazır</Tab>
  <Tab>Eksik Belgeler</Tab>
  <Tab>🏆 Sıralama (Bu ay)</Tab>  {/* ← yeni */}
</Tabs>

// Leaderboard içeriği
<ol className="divide-y divide-stone-100">
  {drivers.sort((a,b) => b.score - a.score).map((d, i) => (
    <li key={d.id} className="flex items-center gap-4 py-3">
      <span className="w-8 text-center font-bold text-stone-400">
        {i === 0 ? '🥇' : i === 1 ? '🥈' : i === 2 ? '🥉' : i + 1}
      </span>
      <Avatar name={d.name} size="sm" />
      <div className="flex-1">
        <p className="font-medium">{d.name}</p>
        <p className="text-xs text-stone-500">{d.vehicle?.plate}</p>
      </div>
      <ScoreBar score={d.score} />
      <span className="font-bold tabular-nums">{d.score}</span>
    </li>
  ))}
</ol>
```

### 4.4 ⚠️ Yakıt Uyarıları — Toplu İşlem & Akıllı Gruplama

En kritik ekran. Burada radikal bir yeniden tasarım öneriyorum.

#### Yeni yapı:

```
┌────────────────────────────────────────────────────────────┐
│ Uyarılar 7 | İçe Aktar | İnceleme 4                [⚙ Ayarlar]│
│                                                              │
│ Yakıt Uyarıları                                              │
│ 7 uyarı · Son 7 gün                                          │
│                                                              │
│ ┌──── SEKMELER ────┐                                         │
│ │ Tümü 7 | Acil 1 | Dikkat 6 | Bilgi 0 | Ertelenen 3 | Kapatılan │
│ └──────────────────┘                                         │
│                                                              │
│ [Arama][Filtre: Araç ▾][Kural ▾][Tarih ▾][Sürücü ▾]        │
│                                                              │
│ ┌─ Toplu işlem çubuğu (3 seçili) ──────────────────────┐   │
│ │ ✓ 3 seçildi  [Onayla] [Ertele] [Ata…] [Notuya ekle] │   │
│ └──────────────────────────────────────────────────────┘   │
│                                                              │
│ ═══ 34 ABC 123 ═══ 1 acil · 5 dikkat ═══ [Tümünü Gör →] ═══│
│ ┌────────────────────────────────────────────────────────┐ │
│ │ ☐ 🔴 ACİL  Şüpheli dolum · %95 üzeri sapma    14 Nis  │ │
│ │      Tutar ₺90 girilmiş; beklenen ₺180  ·  100L / 210k │ │
│ │      💡 Aynı istasyonda 3 ay içinde 4. anomali         │ │
│ │      [Sürücüye sor] [Kabul et] [Reddet]               │ │
│ └────────────────────────────────────────────────────────┘ │
│ ┌────────────────────────────────────────────────────────┐ │
│ │ ☐ 🟡 DİKKAT  Fiyat uyuşmazlığı · %10 sapma   14 Nis   │ │
│ │      Beklenen ₺95,00 · girilen ₺9,50                   │ │
│ │      Muhtemelen giriş hatası: 9,50 → 95,00              │ │
│ │      [Düzelt: ₺95,00] [Reddet]                         │ │
│ └────────────────────────────────────────────────────────┘ │
└────────────────────────────────────────────────────────────┘
```

#### Uygulama kod örnekleri

```jsx
// /app/frontend/src/components/alerts/AlertRow.jsx
import { Check, Clock, UserPlus, StickyNote } from 'lucide-react';

export function AlertRow({ alert, selected, onSelectChange, onAction }) {
  const sev = alert.severity; // 'urgent' | 'attention' | 'info'
  
  const sevStyles = {
    urgent:    { stripe: 'bg-red-500',    pill: 'bg-red-100 text-red-800',     label: 'ACİL' },
    attention: { stripe: 'bg-amber-500',  pill: 'bg-amber-100 text-amber-800', label: 'DİKKAT' },
    info:      { stripe: 'bg-sky-500',    pill: 'bg-sky-100 text-sky-800',     label: 'BİLGİ' },
  }[sev];
  
  return (
    <div data-testid={`alert-row-${alert.id}`}
         className={`group relative flex gap-4 rounded-lg border border-stone-200 bg-white p-4 hover:shadow-sm transition-shadow ${
           selected ? 'ring-2 ring-indigo-500 border-indigo-300' : ''
         }`}>
      {/* Severity stripe */}
      <div className={`absolute left-0 top-0 h-full w-1 rounded-l-lg ${sevStyles.stripe}`} />
      
      {/* Checkbox */}
      <label className="flex items-start pt-1 pl-2">
        <input
          type="checkbox"
          checked={selected}
          onChange={e => onSelectChange(alert.id, e.target.checked)}
          data-testid={`alert-checkbox-${alert.id}`}
          className="h-4 w-4 rounded border-stone-300 text-indigo-600 focus:ring-indigo-500"
        />
      </label>
      
      {/* Content */}
      <div className="flex-1 min-w-0">
        <div className="flex items-center gap-2 flex-wrap">
          <span className={`inline-flex items-center rounded-md px-2 py-0.5 text-xs font-semibold ${sevStyles.pill}`}>
            {sevStyles.label}
          </span>
          <span className="font-semibold text-stone-900">{alert.ruleName}</span>
          {alert.deviation && (
            <span className="inline-flex items-center rounded-md bg-stone-100 px-1.5 py-0.5 text-xs font-mono font-medium text-stone-700">
              {alert.deviation > 0 ? '+' : ''}{alert.deviation}%
            </span>
          )}
          <span className="ml-auto text-xs text-stone-500 tabular-nums">
            {formatDate(alert.occurredAt)}
          </span>
        </div>
        
        <p className="mt-1.5 text-sm text-stone-700">
          {alert.detail}
        </p>
        
        {/* Meta row */}
        <div className="mt-2 flex items-center gap-3 text-xs text-stone-500 tabular-nums">
          <span className="inline-flex items-center gap-1">
            <Clock className="h-3 w-3" /> {alert.time}
          </span>
          <span>•</span>
          <span>₺{alert.amount}</span>
          <span>•</span>
          <span>{alert.liters}L</span>
          <span>•</span>
          <span>{alert.odometer.toLocaleString('tr-TR')} km</span>
        </div>
        
        {/* AI insight — optional but very powerful */}
        {alert.pattern && (
          <div className="mt-2 flex items-start gap-1.5 rounded-md bg-indigo-50 px-2.5 py-1.5 text-xs text-indigo-900">
            <Sparkles className="h-3.5 w-3.5 mt-0.5 flex-shrink-0" />
            <span>{alert.pattern}</span>
          </div>
        )}
        
        {/* Inline actions — only visible on hover */}
        <div className="mt-3 flex items-center gap-2 opacity-0 group-hover:opacity-100 transition-opacity">
          {alert.suggestedFix && (
            <ActionButton variant="primary" onClick={() => onAction('apply-fix', alert)}>
              {alert.suggestedFix.label}
            </ActionButton>
          )}
          <ActionButton variant="ghost" icon={Check} onClick={() => onAction('accept', alert)}>
            Kabul et
          </ActionButton>
          <ActionButton variant="ghost" icon={Clock} onClick={() => onAction('snooze', alert)}>
            Ertele
          </ActionButton>
          <ActionButton variant="ghost" icon={UserPlus} onClick={() => onAction('assign', alert)}>
            Ata
          </ActionButton>
          <ActionButton variant="ghost" icon={StickyNote} onClick={() => onAction('note', alert)}>
            Not ekle
          </ActionButton>
        </div>
      </div>
    </div>
  );
}
```

```jsx
// /app/frontend/src/components/alerts/BulkActionBar.jsx — alt sabit çubuk
import { motion, AnimatePresence } from 'framer-motion';

export function BulkActionBar({ selectedIds, onAction, onClear }) {
  const count = selectedIds.length;
  
  return (
    <AnimatePresence>
      {count > 0 && (
        <motion.div
          initial={{ y: 100, opacity: 0 }}
          animate={{ y: 0, opacity: 1 }}
          exit={{ y: 100, opacity: 0 }}
          transition={{ type: 'spring', damping: 20, stiffness: 300 }}
          data-testid="bulk-action-bar"
          className="fixed bottom-6 left-1/2 -translate-x-1/2 z-40 flex items-center gap-3 rounded-full bg-stone-900 px-5 py-3 text-white shadow-lg">
          <span className="flex items-center gap-2">
            <span className="inline-flex items-center justify-center rounded-full bg-indigo-500 h-6 w-6 text-xs font-bold tabular-nums">
              {count}
            </span>
            <span className="text-sm font-medium">uyarı seçili</span>
          </span>
          
          <div className="h-5 w-px bg-white/20" />
          
          <BulkBtn icon={Check}   onClick={() => onAction('accept')}>Onayla</BulkBtn>
          <BulkBtn icon={Clock}   onClick={() => onAction('snooze')}>Ertele</BulkBtn>
          <BulkBtn icon={UserPlus} onClick={() => onAction('assign')}>Ata</BulkBtn>
          <BulkBtn icon={X}       onClick={() => onAction('dismiss')}>Reddet</BulkBtn>
          
          <div className="h-5 w-px bg-white/20" />
          
          <button onClick={onClear} data-testid="bulk-clear-btn"
                  className="text-xs text-white/60 hover:text-white transition-colors">
            İptal
          </button>
        </motion.div>
      )}
    </AnimatePresence>
  );
}
```

**🧠 Akıllı kural önerileri (pattern detection)**

Backend'de pattern analizi yapın, kullanıcıya şu mesajları gösterin:
- "Bu istasyonda son 3 ayda 4. anomali" → belki istasyonu bloklama
- "Aynı sürücü bu ay 3. şüpheli dolum yaptı" → sürücü profili gözden geçir
- "Bu plaka için tipik: 80L/dolum. Bu sefer: 120L (+%50)" → tek tıkla kabul/ret
- "Benzer bir sorun 34 XYZ 987'de de var" → bulk action ile hepsi birden
### 4.5 📥 İçe Aktar — Sihirbaz Stili & Önizleme

#### İyileştirmeler:

**1. Üç adımlı sihirbaz (wizard pattern):**

```
[1] Dosya Yükle  →  [2] Sütunları Eşle  →  [3] Önizle & Aktar
```

**2. Drag & drop + şablon indirme:**

```jsx
// /app/frontend/src/components/import/FileDropzone.jsx
import { Upload, FileDown } from 'lucide-react';
import { useDropzone } from 'react-dropzone';

export function FileDropzone({ format, onFile }) {
  const { getRootProps, getInputProps, isDragActive } = useDropzone({
    onDrop: (files) => files[0] && onFile(files[0]),
    accept: { 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet': ['.xlsx'] },
    maxFiles: 1,
  });
  
  return (
    <div className="space-y-3">
      <div
        {...getRootProps()}
        data-testid="file-dropzone"
        className={`relative flex flex-col items-center justify-center gap-3 rounded-xl border-2 border-dashed p-10 text-center cursor-pointer transition-all ${
          isDragActive
            ? 'border-indigo-400 bg-indigo-50'
            : 'border-stone-300 bg-stone-50/50 hover:border-stone-400 hover:bg-stone-50'
        }`}>
        <input {...getInputProps()} />
        <div className="rounded-full bg-white p-3 shadow-sm border border-stone-200">
          <Upload className="h-6 w-6 text-stone-600" />
        </div>
        <div>
          <p className="font-semibold text-stone-900">
            {isDragActive ? 'Dosyayı bırakın' : 'Dosyayı buraya sürükleyin'}
          </p>
          <p className="text-sm text-stone-500 mt-1">
            veya <span className="text-indigo-600 underline">bilgisayardan seçin</span> · .xlsx (maks 10MB)
          </p>
        </div>
      </div>
      
      {format && (
        <div className="flex items-center gap-2 rounded-lg bg-stone-50 px-3 py-2 text-sm">
          <FileDown className="h-4 w-4 text-stone-500" />
          <span className="text-stone-600">{format} şablon dosyası ihtiyacınız mı var?</span>
          <button data-testid="download-template-btn"
                  className="ml-auto font-medium text-indigo-600 hover:underline">
            Örnek indir
          </button>
        </div>
      )}
    </div>
  );
}
```

**3. Sütun eşleme sihirbazı:**

```jsx
// /app/frontend/src/components/import/ColumnMapper.jsx
export function ColumnMapper({ fileColumns, requiredFields, mapping, onChange }) {
  return (
    <div className="space-y-3" data-testid="column-mapper">
      <div className="flex items-center justify-between text-xs font-semibold uppercase tracking-wider text-stone-500">
        <span>Dosyadaki sütun</span>
        <span>Naklos alanı</span>
      </div>
      
      {requiredFields.map(field => {
        const autoMatched = mapping[field.key] && fileColumns.includes(mapping[field.key]);
        return (
          <div key={field.key} 
               className="flex items-center gap-3 rounded-lg border border-stone-200 bg-white p-3">
            <select
              value={mapping[field.key] || ''}
              onChange={e => onChange({ ...mapping, [field.key]: e.target.value })}
              data-testid={`mapper-select-${field.key}`}
              className="flex-1 rounded-md border border-stone-200 px-2 py-1.5 text-sm">
              <option value="">— eşleme yok —</option>
              {fileColumns.map(col => (
                <option key={col} value={col}>{col}</option>
              ))}
            </select>
            
            <ArrowRight className="h-4 w-4 text-stone-400 flex-shrink-0" />
            
            <div className="flex-1 flex items-center gap-2">
              <span className="font-medium text-sm">{field.label}</span>
              {field.required && <span className="text-red-500 text-xs">*</span>}
              {autoMatched && (
                <span className="inline-flex items-center gap-1 rounded-md bg-emerald-50 px-1.5 py-0.5 text-xs text-emerald-700">
                  <Sparkles className="h-3 w-3" /> otomatik
                </span>
              )}
            </div>
          </div>
        );
      })}
    </div>
  );
}
```

**4. Önizleme tablosu + hata ayıklama:**

Aktarmadan önce, kullanıcıya ilk 10 satırı göster. Her satır için durum:
- ✅ **Aktarılacak** (yeşil)
- ⚠️ **Uyarı** (örn. plaka filoda yok → yeni oluşturulacak?)
- ❌ **Hata** (zorunlu alan boş, format hatalı)

```jsx
<PreviewTable
  rows={previewData}
  issues={validationIssues}
  onSkipRow={...}
  onFixRow={...}
  data-testid="import-preview-table"
/>
```

---

## 5. İş Akışı Verimliliği

### 5.1 🎛️ Komut Paleti (⌘ K) — Güç Kullanıcısının Süper Silahı

Filo yöneticileri günde 50+ sayfa ziyaretinde bulunur. Klavye tabanlı global komut paleti saatlerinizi kurtarır.

```jsx
// /app/frontend/src/components/CommandPalette.jsx
// Öneri: cmdk kütüphanesi kullanın (shadcn/ui'nin kullandığı)
// yarn add cmdk

import { Command } from 'cmdk';
import { useEffect, useState } from 'react';

export function CommandPalette() {
  const [open, setOpen] = useState(false);
  const [query, setQuery] = useState('');
  const navigate = useNavigate();
  
  useEffect(() => {
    const handler = (e) => {
      if ((e.metaKey || e.ctrlKey) && e.key === 'k') {
        e.preventDefault();
        setOpen(o => !o);
      }
    };
    document.addEventListener('keydown', handler);
    return () => document.removeEventListener('keydown', handler);
  }, []);
  
  return (
    <Command.Dialog open={open} onOpenChange={setOpen} label="Komut menüsü"
                    className="fixed inset-0 z-50 flex items-start justify-center pt-[15vh]">
      <div className="w-full max-w-lg rounded-xl border border-stone-200 bg-white shadow-2xl">
        <Command.Input
          value={query}
          onValueChange={setQuery}
          placeholder="Bir şey ara veya komut yaz…"
          data-testid="cmdk-input"
          className="w-full border-b border-stone-200 bg-transparent px-4 py-3 text-base outline-none placeholder:text-stone-400"
        />
        
        <Command.List className="max-h-[400px] overflow-y-auto p-2">
          <Command.Empty className="py-8 text-center text-sm text-stone-500">
            Eşleşme yok. "34 ABC" gibi plaka deneyin.
          </Command.Empty>
          
          <Command.Group heading="Git">
            <CmdItem icon={Home}       onSelect={() => navigate('/')}>        Ana Sayfa       </CmdItem>
            <CmdItem icon={Truck}      onSelect={() => navigate('/vehicles')}> Araçlar        </CmdItem>
            <CmdItem icon={Users}      onSelect={() => navigate('/drivers')}>  Sürücüler      </CmdItem>
            <CmdItem icon={Fuel}       onSelect={() => navigate('/fuel')}>    Yakıt          </CmdItem>
            <CmdItem icon={AlertTriangle} onSelect={() => navigate('/alerts')}> Uyarılar     </CmdItem>
          </Command.Group>
          
          <Command.Group heading="Aksiyon">
            <CmdItem icon={Plus}       shortcut="⌘ N">  Yeni araç ekle        </CmdItem>
            <CmdItem icon={UserPlus}   shortcut="⌘ D">  Yeni sürücü ekle      </CmdItem>
            <CmdItem icon={FileUp}>                      Yakıt dosyası içe aktar </CmdItem>
            <CmdItem icon={Settings2}>                   Uyarı kurallarını düzenle </CmdItem>
          </Command.Group>
          
          {query.length >= 2 && (
            <Command.Group heading="Sonuçlar">
              {searchResults.map(r => (
                <CmdItem key={r.id} onSelect={() => navigate(r.path)}>
                  <HighlightMatch text={r.title} query={query} />
                  <span className="ml-auto text-xs text-stone-400">{r.type}</span>
                </CmdItem>
              ))}
            </Command.Group>
          )}
        </Command.List>
      </div>
    </Command.Dialog>
  );
}
```

### 5.2 ⌨️ Klavye Kısayolları

Mutlaka olsun:

| Kısayol | Aksiyon |
|---------|---------|
| `⌘ K` / `Ctrl K` | Komut paleti |
| `G` sonra `H` | Git → Ana sayfa |
| `G` sonra `V` | Git → Araçlar |
| `G` sonra `D` | Git → Sürücüler |
| `G` sonra `A` | Git → Uyarılar |
| `/` | Aramayı odakla |
| `N` | Yeni kayıt ekle (bağlama göre) |
| `J` / `K` | Listede yukarı/aşağı |
| `E` | Düzenle |
| `S` | Ertele (snooze) |
| `?` | Kısayol yardımı aç |

Kısayol yardımı modal'ı göstermek için:

```jsx
<Modal open={showShortcuts}>
  <h2>Klavye Kısayolları</h2>
  <dl className="grid grid-cols-2 gap-x-6 gap-y-2">
    {shortcuts.map(s => (
      <>
        <dt><Kbd>{s.key}</Kbd></dt>
        <dd className="text-sm text-stone-600">{s.label}</dd>
      </>
    ))}
  </dl>
</Modal>
```

### 5.3 🔔 Akıllı Bildirim Merkezi

Sağ üstte `Bell` ikonu — tıklayınca popover:

- **Sekmeler:** Hepsi / Okunmamış / Acil
- **Gruplama:** Araç başına, kural başına
- **Aksiyonlar:** Tek tık onayla / ertele / notuya ekle
- **Akıllı:** "Bu saat içinde 3'ten fazla bildirim: özete dönüş" (digest mode)
- **Kanallar:** In-app + Email + SMS (kullanıcı ayarı)

### 5.4 🔁 Undo Pattern (Toast ile)

Her silme/değişiklik sonrası:

```jsx
toast({
  title: '3 uyarı ertelendi',
  description: 'Yarın sabah 09:00\'da tekrar görünecek',
  action: <ToastAction onClick={undo}>Geri Al</ToastAction>,
  duration: 6000,
});
```

**Kural:** "Emin misiniz?" modal'ları sadece **geri alınamaz** işlemlerde (örn. araç silme). Diğer her şeyde → **önce yap, sonra Undo sun**.

---

## 6. Mobil & Responsive Deneyim

Filo yöneticisi masa başında, ama **şoförler sahada, telefonla**. Mobil-öncelikli olmalı.

### 6.1 Mobile Layout Kuralları

- **Üst nav:** Hamburger + Logo + Bildirim/avatar (üst bar sabit)
- **Alt nav (mobile-only):** 4-5 ana sekme (bottom tab bar)
- **CTA'lar:** Floating Action Button (FAB) sağ altta
- **Tablolar yerine:** Kart listesi + swipe-actions

### 6.2 Swipe-to-Act (mobile liste kartları)

```jsx
// /app/frontend/src/components/mobile/SwipeCard.jsx
// Kart'ı sola swipe → "Ertele", "Kabul et", "Reddet" çıkar

import { motion, useMotionValue, useTransform } from 'framer-motion';

export function SwipeCard({ children, actions }) {
  const x = useMotionValue(0);
  const bg = useTransform(x, [-120, 0], ['#f59e0b', '#ffffff']);
  
  return (
    <div className="relative overflow-hidden">
      <motion.div
        style={{ x, backgroundColor: bg }}
        drag="x"
        dragConstraints={{ left: -120, right: 0 }}
        dragElastic={0.1}
        onDragEnd={(_, info) => {
          if (info.offset.x < -80) actions.primary();
        }}
        className="relative z-10 rounded-lg border border-stone-200 p-4">
        {children}
      </motion.div>
      <div className="absolute inset-y-0 right-0 flex items-center gap-2 pr-4">
        <button onClick={actions.primary} className="rounded-full bg-amber-500 p-3 text-white">
          <Clock className="h-5 w-5" />
        </button>
      </div>
    </div>
  );
}
```

### 6.3 Responsive Breakpoint Kuralları

```js
// tailwind.config.js
screens: {
  'xs': '375px',    // küçük telefon
  'sm': '640px',    // büyük telefon / küçük tablet
  'md': '768px',    // tablet
  'lg': '1024px',   // laptop
  'xl': '1280px',   // desktop
  '2xl': '1536px',  // geniş monitor
},
```

**Layout değişiklikleri:**

| Ekran | Ana sayfa KPI grid | Nav | Tablo |
|-------|-------------------|-----|-------|
| `xs-sm` | 1-kolon | Bottom tabs | Kart listesi |
| `md` | 2-kolon | Üst nav | Kart listesi |
| `lg+` | 4-kolon | Üst nav | Tablo |

### 6.4 Touch Target Kuralları

- **Min 44×44px** tüm tıklanabilir elemanlar (Apple HIG)
- Liste satırları arası minimum **8px** boşluk
- Ana CTA butonları **min 48px yükseklik**

---

## 7. Erişilebilirlik (a11y)

### 7.1 Kontrol Listesi (WCAG 2.1 AA)

#### 🎨 Renk & Kontrast
- [ ] Normal metin (14-18px) kontrast oranı ≥ **4.5:1**
- [ ] Büyük metin (18px+) kontrast oranı ≥ **3:1**
- [ ] Durum, **sadece renk ile değil**, ikon/yazı ile de belirtilmeli
  - ❌ Kötü: Sadece kırmızı nokta = hata
  - ✅ İyi: Kırmızı nokta + "Hata" yazısı + `AlertOctagon` ikonu
- [ ] Focus halkası görünür olmalı (`:focus-visible` ile)

```css
/* global focus style */
*:focus-visible {
  outline: 2px solid theme('colors.indigo.500');
  outline-offset: 2px;
  border-radius: 4px;
}
```

#### ⌨️ Klavye Navigasyonu
- [ ] Her tıklanabilir eleman `Tab` ile erişilebilir
- [ ] Modal'lar Escape ile kapanabilir
- [ ] `<button>` için `<div onClick>` yerine gerçek `button` kullan
- [ ] Focus trap: Modal içinde Tab dışarı çıkmamalı

#### 🔊 Ekran Okuyucu
- [ ] Tüm ikonlar `aria-label` ile anlamlandırılmalı
- [ ] Form elemanları `<label>` ile bağlı
- [ ] Canlı bölgeler (toast, uyarı) `role="alert"` veya `aria-live="polite"`
- [ ] Tablolar `<th scope="col">` kullanmalı
- [ ] Landmark'lar: `<nav>`, `<main>`, `<aside>`, `<header>`, `<footer>`

**Örnek düzeltme:**

```jsx
// ❌ Kötü
<div onClick={handleDelete} className="cursor-pointer">
  <Trash className="h-4 w-4" />
</div>

// ✅ İyi
<button
  onClick={handleDelete}
  aria-label="Aracı sil"
  data-testid="delete-vehicle-btn"
  className="rounded p-2 hover:bg-stone-100">
  <Trash className="h-4 w-4" aria-hidden="true" />
</button>
```

#### 📏 Boyut & Zoom
- [ ] Sayfa %200 zoom'da hala kullanılabilir
- [ ] Viewport meta tag `user-scalable=no` İÇERMESİN
- [ ] Minimum font boyutu `14px`

#### 🎥 Hareket & Animasyon
- [ ] `prefers-reduced-motion` destekleyin

```css
@media (prefers-reduced-motion: reduce) {
  *, ::before, ::after {
    animation-duration: 0.01ms !important;
    animation-iteration-count: 1 !important;
    transition-duration: 0.01ms !important;
  }
}
```

### 7.2 Otomatik test

```bash
# yarn dev aşamasında aksesibilite hatalarını logla
yarn add -D @axe-core/react

# App.js
if (process.env.NODE_ENV !== 'production') {
  const ReactDOM = require('react-dom');
  const axe = require('@axe-core/react');
  axe(React, ReactDOM, 1000);
}
```

Lighthouse a11y skoru hedef: **≥ 95**.

---

## 8. Rakip Analizi

### 8.1 Samsara (Lider, ABD)

**Neyi iyi yapıyor:**
- ⭐ **Tek tıkla AI-destekli performans özeti** (ana sayfada)
- ⭐ Fuel receipt AI extract — yakıt fişini fotoğrafla çek, otomatik doldur
- ⭐ Driver App'te distraction-free mode + dark mode
- ⭐ Canlı harita + ısı haritası (hotspots of incidents)
- ⭐ Role-based dashboard (dispatcher vs fleet manager vs safety)

**Naklos'a taşınabilecek:**
1. **AI yakıt fişi okuma** (gelecek özellik — Gemini Nano Banana ile entegre edebilirsiniz)
2. **Rol bazlı dashboard** (işletme sahibi vs operatör)
3. **Mobil Driver App** ayrı uygulama olarak

### 8.2 Fleetio (SMB-orta segment, ABD)

**Neyi iyi yapıyor:**
- ⭐ **Özelleştirilebilir raporlar** + kayıt şablonu
- ⭐ Vehicle health score (her araca bir skor)
- ⭐ 3-tap fuel logging (mobilde)
- ⭐ Odometer auto-sync (telematics entegrasyonlarıyla)
- ⭐ Inspection templates (sürücünün sahada doldurması için)

**Naklos'a taşınabilecek:**
1. **Araç sağlık skoru** (yaş + km + belge + yakıt verimi composite)
2. **Sürücü günlük kontrol listesi** (çıkış öncesi mobilde doldurulan)
3. **Özel rapor oluşturucu** (drag & drop field'lar)

### 8.3 Verizon Connect (Enterprise, global)

**Neyi iyi yapıyor:**
- ⭐ **Rota optimizasyonu** (ekonomik rota önerileri)
- ⭐ Compliance merkezi (tek ekranda tüm yasal belgeler)
- ⭐ ROI hesaplayıcı / benchmark (endüstri ortalamasıyla karşılaştırma)
- ⭐ Geofencing + hız sınırı uyarıları

**Naklos'a taşınabilecek:**
1. **Compliance center** — Türkiye'ye özel (SRC, K-belgesi, ADR, Muayene, Egzoz, vb.)
2. **Benchmark** — "Filonuz km başı ₺3.21 harcıyor, Türkiye ortalaması ₺3.50" gibi
3. **Geofencing** — depoya girdi/çıktı bildirimi

### 8.4 Karşılaştırma Tablosu

| Özellik | Samsara | Fleetio | Verizon | Naklos (şu an) | Naklos (hedef) |
|---------|---------|---------|---------|----------------|----------------|
| Canlı harita | ✅ | ⚠️ | ✅ | ❌ | **✅ MVP** |
| AI analiz | ✅ | ⚠️ | ⚠️ | ❌ | **✅ Faz 2** |
| Mobil driver app | ✅ | ✅ | ✅ | ❌ | **✅ Faz 2** |
| Yakıt uyarıları | ✅ | ⚠️ | ✅ | ✅ | ✅ (zaten güçlü) |
| Belge yönetimi | ⚠️ | ✅ | ✅ | ✅ | ✅ (zaten iyi) |
| Rota optimizasyon | ✅ | ❌ | ✅ | ❌ | ⏳ Faz 3 |
| Özel raporlar | ⚠️ | ✅ | ✅ | ❌ | **✅ Faz 2** |
| Sürücü skoru | ✅ | ✅ | ⚠️ | ❌ | **✅ Faz 1** |
| Türkiye-özel uyum | ❌ | ❌ | ❌ | ✅ | ✅ **farklılaştırıcı** |
| Fiyat | $$$$ | $$$ | $$$$ | $ | $$ |

**🎯 Naklos'un kazanma stratejisi:** **Türkiye'ye özel + SMB fiyatlama + modern UX**. Uluslararası rakipler çok pahalı ve Türkiye'nin yasal detaylarına vakıf değil.

---

## 9. Özellik Yol Haritası

### 9.1 🟢 MUST-HAVE (Faz 1 — 4-6 hafta)

Kullanıcının **"bunsuz olmaz"** dediği özellikler.

#### A. Dashboard Yenileme
- [ ] Komuta çubuğu (bugünün özeti)
- [ ] KPI grid (4 kart: aktif filo, aylık yakıt, km başı maliyet, şüpheli dolum)
- [ ] Belge zaman çizelgesi (önümüzdeki 90 gün)
- [ ] Trend grafiği (aylık yakıt tüketimi — recharts)

#### B. Uyarılar — Toplu İşlemler
- [ ] Checkbox + bulk action bar (Onayla / Ertele / Ata / Reddet)
- [ ] Snooze modal'ı ("1 saat / 1 gün / Pazartesi / özel")
- [ ] Undo toast (6 saniye)
- [ ] Filtre arama (plaka/kural type-ahead)
- [ ] Pattern insight kutusu (manuel başlangıç, sonra AI)

#### C. Komut Paleti (⌘ K)
- [ ] Sayfa navigasyonu
- [ ] Hızlı arama (araç, sürücü, plaka)
- [ ] Temel aksiyonlar (araç ekle, sürücü ekle)

#### D. Sürücü Kartı İyileştirme
- [ ] Avatar (gravatar / upload)
- [ ] Performans skoru (basitçe: yakıt verimi + belge tamlığı + uyarı adedi)
- [ ] Hızlı aksiyonlar (ara, mesaj, belgeler)

#### E. Tasarım Sistemi Temelleri
- [ ] CSS değişkenleri (token'lar)
- [ ] Tipografi scale
- [ ] Tailwind config güncelleme
- [ ] Button / Input / Card / Badge bileşenleri
- [ ] Dark mode desteği

#### F. Erişilebilirlik Temelleri
- [ ] Focus halkaları
- [ ] Aria-label tüm ikon butonlarda
- [ ] Klavye navigasyonu (Tab, Escape)
- [ ] `data-testid` tüm interaktif elemanlarda

### 9.2 🟡 NICE-TO-HAVE (Faz 2 — 6-10 hafta)

Kullanıcıyı **"vay be"** dedirtecek özellikler.

#### G. Canlı Harita
- [ ] Mapbox/Leaflet entegrasyonu
- [ ] Araç konum noktaları (renkli: aktif/idle/offline)
- [ ] Tıklanabilir popup (son hız, sürücü, konum)
- [ ] Geofence çizme aracı

#### H. Araç Detay Sayfası
- [ ] Sağ tarafta drawer açılır (modal değil)
- [ ] Sekmeler: Genel / Belgeler / Yakıt Geçmişi / Bakım / Uyarılar
- [ ] Zaman çizelgesi ile tüm olaylar
- [ ] Araç sağlık skoru (composite)

#### I. Rapor & Dışa Aktarma
- [ ] PDF rapor (aylık filo özeti)
- [ ] CSV/Excel dışa aktarma her liste için
- [ ] Planlı raporlar (her Pazartesi sabah 9'da email)
- [ ] Özel filtre kaydetme

#### J. Bildirim Merkezi
- [ ] Sağ üstte bell + badge
- [ ] Grupla: araç bazında, kural bazında, okunmamış
- [ ] Multi-channel: email / SMS / WhatsApp / push
- [ ] Kullanıcı tercihi sayfası (her kural için kanal seçimi)

#### K. Sürücü Mobil Uygulaması (veya PWA)
- [ ] Günlük kontrol listesi (çıkış öncesi)
- [ ] Yakıt fişi fotoğrafı (AI ile OCR — Gemini 3)
- [ ] Belge yükleme
- [ ] Konum paylaşımı (manuel veya auto)

#### L. AI Destekli Pattern Detection
- [ ] "Bu istasyonda sık anomali" uyarısı
- [ ] "Sürücü X bu ay 5. şüpheli dolum" uyarısı
- [ ] Anomali skoru (% bazlı)
- [ ] Benzer uyarıları otomatik grupla

### 9.3 🔵 FUTURE / WOW (Faz 3 — 3-6 ay)

#### M. Rota Optimizasyonu
- [ ] Google Maps / OSRM entegrasyonu
- [ ] Yakıt verimliliğine göre rota önerisi
- [ ] Tarihî trafik verileri

#### N. Predictive Maintenance
- [ ] "Bu araç 2 hafta içinde servis ister"
- [ ] Km/yaş/belirtiler bazlı model
- [ ] Önleyici bakım takvimi

#### O. Entegrasyonlar Marketplace
- [ ] Opet, Shell, BP, Petrol Ofisi fuel card API'leri
- [ ] Araç takip cihazları (Arvento, Mobiliz, vs.)
- [ ] Muhasebe (Logo, Mikro, Netsis)
- [ ] WhatsApp Business API (şoför bildirimleri)

#### P. Çok Kullanıcılı / Rol Yönetimi
- [ ] Rolller: Owner / Fleet Manager / Accountant / Driver
- [ ] Her rol için özel dashboard
- [ ] Approval workflow (örn. 500₺ üzeri yakıt → onay gerektir)

#### Q. Benchmark Portal
- [ ] "Sektörünüzle karşılaştırma" widget'ı
- [ ] Sektör: Lojistik, Soğuk zincir, Kuru yük, Şehir içi teslim…
- [ ] Anonim veri havuzu (opt-in)

#### R. Karbon Ayak İzi
- [ ] CO₂ emisyonu hesaplama (yakıttan)
- [ ] Aylık/yıllık trend
- [ ] Rapor (ESG uyumlu — büyük müşteriler için önemli)

---

## 10. Uygulama Öncelik Matrisi

İyileştirmeleri **etki × efor** grid'inde sıraladık:

```
    YÜKSEK ETKİ
    ┌─────────────────────────────────────┐
    │                                      │
    │  ⭐ HEMEN YAP            🏆 PLANLA  │
    │                                      │
    │  • Komuta çubuğu         • Canlı    │
    │  • Bulk actions            harita   │
    │  • Tasarım tokens        • Driver   │
    │  • ⌘K komut pal.           mobil    │
    │  • KPI kartları          • AI       │
    │  • a11y temelleri          pattern  │
    │                                      │
    │─────────────────────────────────────│
    │                                      │
    │  🎨 BOŞ ZAMANDA        🗑️ ATLA      │
    │                                      │
    │  • Sparkline             • Gradients│
    │  • Micro-animations      • 3D ikon  │
    │  • Avatar auto           • Skeuo-   │
    │  • Dark mode               morfizm  │
    │                                      │
    └─────────────────────────────────────┘
  DÜŞÜK EFOR              YÜKSEK EFOR
```

### 10.1 Sprint Planı (2 haftalık sprint'ler)

**Sprint 1: Tasarım Sistemi (Foundation)**
- Design tokens (CSS değişkenleri)
- Tipografi + font migration
- Button / Input / Card bileşenleri
- Dark mode altyapısı

**Sprint 2: Ana Sayfa V2**
- Komuta çubuğu
- KPI kartları (4 adet)
- Belge zaman çizelgesi
- Responsive grid

**Sprint 3: Uyarılar V2**
- Bulk action bar
- Snooze / assign modal'ları
- Filtre geliştirme
- Undo toast

**Sprint 4: Komut Paleti + Klavye**
- ⌘K palette
- Global keyboard shortcuts
- Quick search

**Sprint 5: Sürücüler + Araçlar**
- Avatar + skor
- Tablo görünümü
- Hover aksiyonları
- Harita görünümü (MVP)

**Sprint 6: A11y + QA Turu**
- WCAG AA denetimi
- Lighthouse optimizasyonu
- Cross-browser test
- Mobile responsive düzeltmeler

---

## 11. Ek: Kod Bileşenleri Kütüphanesi

### 11.1 Button (tam varyantlarıyla)

```jsx
// /app/frontend/src/components/ui/Button.jsx
import { forwardRef } from 'react';
import { cn } from '@/lib/utils';
import { Loader2 } from 'lucide-react';

const variants = {
  primary:   'bg-indigo-600 text-white hover:bg-indigo-700 focus-visible:ring-indigo-500 shadow-sm',
  secondary: 'bg-white border border-stone-200 text-stone-900 hover:bg-stone-50 focus-visible:ring-stone-400',
  ghost:     'bg-transparent text-stone-700 hover:bg-stone-100 focus-visible:ring-stone-400',
  danger:    'bg-red-600 text-white hover:bg-red-700 focus-visible:ring-red-500',
  outline:   'bg-transparent border border-stone-300 text-stone-700 hover:bg-stone-50',
};

const sizes = {
  xs: 'h-7 px-2 text-xs gap-1',
  sm: 'h-8 px-3 text-sm gap-1.5',
  md: 'h-10 px-4 text-sm gap-2',
  lg: 'h-12 px-6 text-base gap-2',
};

export const Button = forwardRef(({ 
  variant = 'primary', size = 'md', 
  loading, icon: Icon, iconRight: IconRight,
  className, children, disabled, ...props 
}, ref) => (
  <button
    ref={ref}
    disabled={disabled || loading}
    className={cn(
      'inline-flex items-center justify-center rounded-lg font-medium',
      'transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-offset-2',
      'disabled:opacity-50 disabled:cursor-not-allowed',
      variants[variant],
      sizes[size],
      className
    )}
    {...props}>
    {loading ? <Loader2 className="h-4 w-4 animate-spin" /> : Icon && <Icon className="h-4 w-4" aria-hidden="true" />}
    {children}
    {IconRight && <IconRight className="h-4 w-4" aria-hidden="true" />}
  </button>
));
Button.displayName = 'Button';
```

### 11.2 Badge

```jsx
// /app/frontend/src/components/ui/Badge.jsx
const tones = {
  neutral: 'bg-stone-100 text-stone-700',
  info:    'bg-sky-50 text-sky-700 border border-sky-100',
  success: 'bg-emerald-50 text-emerald-700 border border-emerald-100',
  warning: 'bg-amber-50 text-amber-700 border border-amber-100',
  danger:  'bg-red-50 text-red-700 border border-red-100',
};

export function Badge({ tone = 'neutral', icon: Icon, children, className }) {
  return (
    <span className={cn(
      'inline-flex items-center gap-1 rounded-md px-2 py-0.5 text-xs font-medium',
      tones[tone], className
    )}>
      {Icon && <Icon className="h-3 w-3" aria-hidden="true" />}
      {children}
    </span>
  );
}
```

### 11.3 EmptyState

```jsx
// /app/frontend/src/components/ui/EmptyState.jsx
export function EmptyState({ icon: Icon, title, description, action }) {
  return (
    <div className="flex flex-col items-center justify-center py-16 text-center">
      {Icon && (
        <div className="rounded-full bg-stone-100 p-4 mb-4">
          <Icon className="h-8 w-8 text-stone-400" />
        </div>
      )}
      <h3 className="text-lg font-semibold text-stone-900">{title}</h3>
      {description && <p className="mt-1.5 text-sm text-stone-500 max-w-sm">{description}</p>}
      {action && <div className="mt-6">{action}</div>}
    </div>
  );
}

// Kullanım:
<EmptyState
  icon={Truck}
  title="Henüz araç eklenmemiş"
  description="İlk aracınızı ekleyin ve filonuzu yönetmeye başlayın."
  action={<Button icon={Plus}>Araç Ekle</Button>}
/>
```

### 11.4 Tooltip

```jsx
// Radix UI veya sadece Floating UI — hangisi zaten kurulu?
// En hafifi: sadece CSS + title alternatifi olarak

import * as TooltipPrimitive from '@radix-ui/react-tooltip';

export function Tooltip({ content, children, side = 'top' }) {
  return (
    <TooltipPrimitive.Provider delayDuration={300}>
      <TooltipPrimitive.Root>
        <TooltipPrimitive.Trigger asChild>{children}</TooltipPrimitive.Trigger>
        <TooltipPrimitive.Portal>
          <TooltipPrimitive.Content
            side={side}
            sideOffset={4}
            className="z-50 rounded-md bg-stone-900 px-2 py-1 text-xs text-white shadow-md
                       animate-in fade-in-0 zoom-in-95 data-[state=closed]:animate-out
                       data-[state=closed]:fade-out-0">
            {content}
            <TooltipPrimitive.Arrow className="fill-stone-900" />
          </TooltipPrimitive.Content>
        </TooltipPrimitive.Portal>
      </TooltipPrimitive.Root>
    </TooltipPrimitive.Provider>
  );
}
```

### 11.5 Boş durum (Empty state) örnekleri

```jsx
// Yakıt uyarı yokken
<EmptyState
  icon={CheckCircle2}
  title="Her şey yolunda! ✨"
  description="Son 7 günde incelemen gereken hiçbir uyarı yok."
  action={
    <div className="flex gap-2">
      <Button variant="secondary">Geçmişi görüntüle</Button>
      <Button variant="ghost">Kural ayarları</Button>
    </div>
  }
/>

// İlk kez gelen kullanıcı için
<EmptyState
  icon={Sparkles}
  title="Naklos'a hoş geldin!"
  description="3 adımda filonu kurulumlamaya başla:"
  action={
    <ol className="space-y-2 text-left">
      <Step done={vehicles.length > 0} label="İlk aracını ekle" cta="Araç Ekle" />
      <Step done={drivers.length > 0}  label="Sürücünü ekle"    cta="Sürücü Ekle" />
      <Step done={imports.length > 0}  label="Yakıt verini yükle" cta="Dosya Aktar" />
    </ol>
  }
/>
```

---

## 🎁 Bonus: 10 Hızlı Kazanımlar (≤ 1 gün her biri)

Bugün başlayabileceğiniz, anında görsel etki yaratacak şeyler:

1. **Monospace plaka formatı** → `<span className="font-mono tracking-wide">34 ABC 123</span>`
2. **Hover'da kart lift** → `className="hover:-translate-y-0.5 hover:shadow-md transition-all duration-150"`
3. **Tabular-nums** → tüm sayı/para göstergelerinde → `className="tabular-nums"`
4. **Relative time** → "14 Nis 2026 13:02" yerine "2 saat önce" (mouse-over'da tam tarih)
5. **Skeleton loaders** → spinner yerine gri bloklar (algılanan hız ↑)
6. **Avatar initials** → fotoğraf yoksa "JD" gibi renkli daire (deterministik renk)
7. **"Berlin · 11 saat önce"** → İkon ekleyin → `<MapPin className="h-3 w-3 inline mr-0.5" />`
8. **Empty state'leri değiştirin** → tüm "veri yok" ekranlarını aksiyonlu hale getirin
9. **Toast ile feedback** → her create/update/delete sonrası 2 saniyelik toast
10. **Klavye odağı (focus-visible)** → CSS variable olarak indigo renkte halka

---

## 📚 Referans Okumalar

- [Refactoring UI](https://www.refactoringui.com/) — Adam Wathan (Tailwind yaratıcısı)
- [Samsara Design System](https://www.samsara.com/design) — güncel dashboard kalıpları
- [Radix UI](https://www.radix-ui.com/) — erişilebilir headless bileşenler
- [shadcn/ui](https://ui.shadcn.com/) — copy-paste React bileşenleri
- [Tailwind CSS](https://tailwindcss.com/docs) — utility-first CSS
- [cmdk](https://cmdk.paco.me/) — komut paleti kütüphanesi
- [Framer Motion](https://www.framer.com/motion/) — animasyon kütüphanesi

---

## 📞 Son Söz

Naklos **harika bir temel** üzerine kurulu. Şimdi onu:
1. **Yöneticiyi** günde 2 saat işten kurtaran
2. **Tasarımsal olarak** uluslararası seviyede
3. **Erişilebilir** (herkes için kullanılabilir)
4. **Verimli** (klavye + toplu işlem + akıllı gruplama)

…bir ürüne dönüştürme zamanı.

**Önerim:** Faz 1'deki Must-Have'lerle başlayın. 4-6 hafta içinde kullanıcılarınız ciddi fark hissedecek. Sonra Faz 2'yle **gerçek rekabet avantajı** yaratın.

Başarılar! 🚀

---

*Bu rehber, Naklos ekibi için özel olarak hazırlanmıştır.  
Sorular için dökümandaki herhangi bir bölüme referans verebilirsiniz (örn: "4.4'teki bulk action bar'ı detaylandır").*
