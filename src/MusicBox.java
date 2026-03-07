
public class MusicBox {

    // Variables
    private String songID;
    private char isSongPremium;
    public String songTitle;
    private String songArtists;
    private String songAlbum;
    public String songGenre;
    private String songProducer;
    public String songMusicLabel;
    public int noAds;

    //Constructor
    public MusicBox(String songID, char premiumSong, String title, String artists, String Album, String genre, String producer, String label) {
        this.songID = songID;
        this.isSongPremium = premiumSong;
        this.songArtists = artists;
        
        // -- TODO
MusicBox mbox2 = new MusicBox("A12BC34", 'N', "Sunshine", "Bright", 
    "Happy day", "Pop", "Star Music", "Sunny Vibes");

playsong.playSong(mbox2.getSongID(), mbox2.getPremiumSong(), 1);
        /* Initialise  the rest of the variables in this Constructor block*/
    }
    
    this.songTitle = title;       // 初始化歌曲标题
        this.songAlbum = Album;       // 初始化歌曲专辑
        this.songGenre = genre;       // 初始化歌曲流派
        this.songProducer = producer; // 初始化歌曲制作人
        this.songMusicLabel = label;  // 初始化歌曲唱片公司
    //Methods
    public String getSongID() {
        return songID;
    }

    public String getSongArtists() {
        return songArtists;
    }

    public char getPremiumSong() {
        return isSongPremium;
    }


    public String getSongTitle() {
        return songTitle;
    }

    public String getSongAlbum() {
        return songAlbum;
    }

    public String getSongGenre() {
        return songGenre;
    }

    public String getSongProducer() {
        return songProducer;
    }

    public String getSongMusicLabel() {
        return songMusicLabel;
    }

    public int getNoAds() {
        return noAds;
    }
    
}

