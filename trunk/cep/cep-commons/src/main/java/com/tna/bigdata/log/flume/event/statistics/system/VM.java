package com.tna.log.flume.event.statistics.system;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 17.
 * Time: AM 11:21
 * VM
 * Paging and Virtual Memory
 * nr_dirty
 * nr_writeback
 * nr_unstable
 * nr_page_table_pages
 * nr_mapped
 * nr_slab
 * pgpgin
 * pgpgout
 * pswpin
 * pswpout
 * pgfree
 * pgactivate
 * pgdeactivate
 * pgfault
 * pgmajfault
 * pginodesteal
 * slabs_scanned
 * kswapd_steal
 * kswapd_inodesteal
 * pageoutrun
 * allocstall
 * pgrotated
 * pgalloc_high
 * pgalloc_normal
 * pgalloc_dma
 * pgrefill_high
 * pgrefill_normal
 * pgrefill_dma
 * pgsteal_high
 * pgsteal_normal
 * pgsteal_dma
 * pgscan_kswapd_high
 * pgscan_kswapd_normal
 * pgscan_kswapd_dma
 * pgscan_direct_high
 * pgscan_direct_normal
 * pgscan_direct_dma
 */
public class VM implements Serializable {
    private String nrDirty;
    private String nrWriteback;
    private String nrUnstable;
    private String nrPageTablePages;
    private String nrMapped;
    private String nrSlab;
    private String pgpgin;
    private String pgpgout;
    private String pswpin;
    private String pswpout;
    private String pgfree;
    private String pgactivate;
    private String pgdeactivate;
    private String pgfault;
    private String pgmajfault;
    private String pginodesteal;
    private String slabsScanned;
    private String kswapdSteal;
    private String kswapdInodesteal;
    private String pageoutrun;
    private String allocstall;
    private String pgrotated;
    private String pgallocHigh;
    private String pgallocNormal;
    private String pgallocDma;
    private String pgrefillHigh;
    private String pgrefillNormal;
    private String pgrefillDma;
    private String pgstealHigh;
    private String pgstealNormal;
    private String pgstealDma;
    private String pgscanKswapdHigh;
    private String pgscanKswapdNormal;
    private String pgscanKswapdDma;
    private String pgscanDirectHigh;
    private String pgscanDirectNormal;
    private String pgscanDirectDma;

    public VM(String nrDirty, String nrWriteback, String nrUnstable, String nrPageTablePages, String nrMapped, String nrSlab, String pgpgin, String pgpgout, String pswpin, String pswpout, String pgfree, String pgactivate, String pgdeactivate, String pgfault, String pgmajfault, String pginodesteal, String slabsScanned, String kswapdSteal, String kswapdInodesteal, String pageoutrun, String allocstall, String pgrotated, String pgallocHigh, String pgallocNormal, String pgallocDma, String pgrefillHigh, String pgrefillNormal, String pgrefillDma, String pgstealHigh, String pgstealNormal, String pgstealDma, String pgscanKswapdHigh, String pgscanKswapdNormal, String pgscanKswapdDma, String pgscanDirectHigh, String pgscanDirectNormal, String pgscanDirectDma) {
        this.nrDirty = nrDirty;
        this.nrWriteback = nrWriteback;
        this.nrUnstable = nrUnstable;
        this.nrPageTablePages = nrPageTablePages;
        this.nrMapped = nrMapped;
        this.nrSlab = nrSlab;
        this.pgpgin = pgpgin;
        this.pgpgout = pgpgout;
        this.pswpin = pswpin;
        this.pswpout = pswpout;
        this.pgfree = pgfree;
        this.pgactivate = pgactivate;
        this.pgdeactivate = pgdeactivate;
        this.pgfault = pgfault;
        this.pgmajfault = pgmajfault;
        this.pginodesteal = pginodesteal;
        this.slabsScanned = slabsScanned;
        this.kswapdSteal = kswapdSteal;
        this.kswapdInodesteal = kswapdInodesteal;
        this.pageoutrun = pageoutrun;
        this.allocstall = allocstall;
        this.pgrotated = pgrotated;
        this.pgallocHigh = pgallocHigh;
        this.pgallocNormal = pgallocNormal;
        this.pgallocDma = pgallocDma;
        this.pgrefillHigh = pgrefillHigh;
        this.pgrefillNormal = pgrefillNormal;
        this.pgrefillDma = pgrefillDma;
        this.pgstealHigh = pgstealHigh;
        this.pgstealNormal = pgstealNormal;
        this.pgstealDma = pgstealDma;
        this.pgscanKswapdHigh = pgscanKswapdHigh;
        this.pgscanKswapdNormal = pgscanKswapdNormal;
        this.pgscanKswapdDma = pgscanKswapdDma;
        this.pgscanDirectHigh = pgscanDirectHigh;
        this.pgscanDirectNormal = pgscanDirectNormal;
        this.pgscanDirectDma = pgscanDirectDma;
    }

    public String getAllocstall() {
        return allocstall;
    }

    public void setAllocstall(String allocstall) {
        this.allocstall = allocstall;
    }

    public String getKswapdInodesteal() {
        return kswapdInodesteal;
    }

    public void setKswapdInodesteal(String kswapdInodesteal) {
        this.kswapdInodesteal = kswapdInodesteal;
    }

    public String getKswapdSteal() {
        return kswapdSteal;
    }

    public void setKswapdSteal(String kswapdSteal) {
        this.kswapdSteal = kswapdSteal;
    }

    public String getNrDirty() {
        return nrDirty;
    }

    public void setNrDirty(String nrDirty) {
        this.nrDirty = nrDirty;
    }

    public String getNrMapped() {
        return nrMapped;
    }

    public void setNrMapped(String nrMapped) {
        this.nrMapped = nrMapped;
    }

    public String getNrPageTablePages() {
        return nrPageTablePages;
    }

    public void setNrPageTablePages(String nrPageTablePages) {
        this.nrPageTablePages = nrPageTablePages;
    }

    public String getNrSlab() {
        return nrSlab;
    }

    public void setNrSlab(String nrSlab) {
        this.nrSlab = nrSlab;
    }

    public String getNrUnstable() {
        return nrUnstable;
    }

    public void setNrUnstable(String nrUnstable) {
        this.nrUnstable = nrUnstable;
    }

    public String getNrWriteback() {
        return nrWriteback;
    }

    public void setNrWriteback(String nrWriteback) {
        this.nrWriteback = nrWriteback;
    }

    public String getPageoutrun() {
        return pageoutrun;
    }

    public void setPageoutrun(String pageoutrun) {
        this.pageoutrun = pageoutrun;
    }

    public String getPgactivate() {
        return pgactivate;
    }

    public void setPgactivate(String pgactivate) {
        this.pgactivate = pgactivate;
    }

    public String getPgallocDma() {
        return pgallocDma;
    }

    public void setPgallocDma(String pgallocDma) {
        this.pgallocDma = pgallocDma;
    }

    public String getPgallocHigh() {
        return pgallocHigh;
    }

    public void setPgallocHigh(String pgallocHigh) {
        this.pgallocHigh = pgallocHigh;
    }

    public String getPgallocNormal() {
        return pgallocNormal;
    }

    public void setPgallocNormal(String pgallocNormal) {
        this.pgallocNormal = pgallocNormal;
    }

    public String getPgdeactivate() {
        return pgdeactivate;
    }

    public void setPgdeactivate(String pgdeactivate) {
        this.pgdeactivate = pgdeactivate;
    }

    public String getPgfault() {
        return pgfault;
    }

    public void setPgfault(String pgfault) {
        this.pgfault = pgfault;
    }

    public String getPgfree() {
        return pgfree;
    }

    public void setPgfree(String pgfree) {
        this.pgfree = pgfree;
    }

    public String getPginodesteal() {
        return pginodesteal;
    }

    public void setPginodesteal(String pginodesteal) {
        this.pginodesteal = pginodesteal;
    }

    public String getPgmajfault() {
        return pgmajfault;
    }

    public void setPgmajfault(String pgmajfault) {
        this.pgmajfault = pgmajfault;
    }

    public String getPgpgin() {
        return pgpgin;
    }

    public void setPgpgin(String pgpgin) {
        this.pgpgin = pgpgin;
    }

    public String getPgpgout() {
        return pgpgout;
    }

    public void setPgpgout(String pgpgout) {
        this.pgpgout = pgpgout;
    }

    public String getPgrefillDma() {
        return pgrefillDma;
    }

    public void setPgrefillDma(String pgrefillDma) {
        this.pgrefillDma = pgrefillDma;
    }

    public String getPgrefillHigh() {
        return pgrefillHigh;
    }

    public void setPgrefillHigh(String pgrefillHigh) {
        this.pgrefillHigh = pgrefillHigh;
    }

    public String getPgrefillNormal() {
        return pgrefillNormal;
    }

    public void setPgrefillNormal(String pgrefillNormal) {
        this.pgrefillNormal = pgrefillNormal;
    }

    public String getPgrotated() {
        return pgrotated;
    }

    public void setPgrotated(String pgrotated) {
        this.pgrotated = pgrotated;
    }

    public String getPgscanDirectDma() {
        return pgscanDirectDma;
    }

    public void setPgscanDirectDma(String pgscanDirectDma) {
        this.pgscanDirectDma = pgscanDirectDma;
    }

    public String getPgscanDirectHigh() {
        return pgscanDirectHigh;
    }

    public void setPgscanDirectHigh(String pgscanDirectHigh) {
        this.pgscanDirectHigh = pgscanDirectHigh;
    }

    public String getPgscanDirectNormal() {
        return pgscanDirectNormal;
    }

    public void setPgscanDirectNormal(String pgscanDirectNormal) {
        this.pgscanDirectNormal = pgscanDirectNormal;
    }

    public String getPgscanKswapdDma() {
        return pgscanKswapdDma;
    }

    public void setPgscanKswapdDma(String pgscanKswapdDma) {
        this.pgscanKswapdDma = pgscanKswapdDma;
    }

    public String getPgscanKswapdHigh() {
        return pgscanKswapdHigh;
    }

    public void setPgscanKswapdHigh(String pgscanKswapdHigh) {
        this.pgscanKswapdHigh = pgscanKswapdHigh;
    }

    public String getPgscanKswapdNormal() {
        return pgscanKswapdNormal;
    }

    public void setPgscanKswapdNormal(String pgscanKswapdNormal) {
        this.pgscanKswapdNormal = pgscanKswapdNormal;
    }

    public String getPgstealDma() {
        return pgstealDma;
    }

    public void setPgstealDma(String pgstealDma) {
        this.pgstealDma = pgstealDma;
    }

    public String getPgstealHigh() {
        return pgstealHigh;
    }

    public void setPgstealHigh(String pgstealHigh) {
        this.pgstealHigh = pgstealHigh;
    }

    public String getPgstealNormal() {
        return pgstealNormal;
    }

    public void setPgstealNormal(String pgstealNormal) {
        this.pgstealNormal = pgstealNormal;
    }

    public String getPswpin() {
        return pswpin;
    }

    public void setPswpin(String pswpin) {
        this.pswpin = pswpin;
    }

    public String getPswpout() {
        return pswpout;
    }

    public void setPswpout(String pswpout) {
        this.pswpout = pswpout;
    }

    public String getSlabsScanned() {
        return slabsScanned;
    }

    public void setSlabsScanned(String slabsScanned) {
        this.slabsScanned = slabsScanned;
    }

    @Override
    public String toString() {
        return "VM{" +
                "allocstall='" + allocstall + '\'' +
                ", nrDirty='" + nrDirty + '\'' +
                ", nrWriteback='" + nrWriteback + '\'' +
                ", nrUnstable='" + nrUnstable + '\'' +
                ", nrPageTablePages='" + nrPageTablePages + '\'' +
                ", nrMapped='" + nrMapped + '\'' +
                ", nrSlab='" + nrSlab + '\'' +
                ", pgpgin='" + pgpgin + '\'' +
                ", pgpgout='" + pgpgout + '\'' +
                ", pswpin='" + pswpin + '\'' +
                ", pswpout='" + pswpout + '\'' +
                ", pgfree='" + pgfree + '\'' +
                ", pgactivate='" + pgactivate + '\'' +
                ", pgdeactivate='" + pgdeactivate + '\'' +
                ", pgfault='" + pgfault + '\'' +
                ", pgmajfault='" + pgmajfault + '\'' +
                ", pginodesteal='" + pginodesteal + '\'' +
                ", slabsScanned='" + slabsScanned + '\'' +
                ", kswapdSteal='" + kswapdSteal + '\'' +
                ", kswapdInodesteal='" + kswapdInodesteal + '\'' +
                ", pageoutrun='" + pageoutrun + '\'' +
                ", pgrotated='" + pgrotated + '\'' +
                ", pgallocHigh='" + pgallocHigh + '\'' +
                ", pgallocNormal='" + pgallocNormal + '\'' +
                ", pgallocDma='" + pgallocDma + '\'' +
                ", pgrefillHigh='" + pgrefillHigh + '\'' +
                ", pgrefillNormal='" + pgrefillNormal + '\'' +
                ", pgrefillDma='" + pgrefillDma + '\'' +
                ", pgstealHigh='" + pgstealHigh + '\'' +
                ", pgstealNormal='" + pgstealNormal + '\'' +
                ", pgstealDma='" + pgstealDma + '\'' +
                ", pgscanKswapdHigh='" + pgscanKswapdHigh + '\'' +
                ", pgscanKswapdNormal='" + pgscanKswapdNormal + '\'' +
                ", pgscanKswapdDma='" + pgscanKswapdDma + '\'' +
                ", pgscanDirectHigh='" + pgscanDirectHigh + '\'' +
                ", pgscanDirectNormal='" + pgscanDirectNormal + '\'' +
                ", pgscanDirectDma='" + pgscanDirectDma + '\'' +
                '}';
    }
}
