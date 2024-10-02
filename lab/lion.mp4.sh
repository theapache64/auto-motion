ffpb -y \
    -i "/Users/theapache64/Documents/projects/auto-motion/lab/lion.mp4" \
    -i "/Users/theapache64/Documents/projects/auto-motion/lab/lost_in_time.mp3" \
    -f lavfi -i color=c=black:s="1280"x"720":sar=1/1:d=3.0 \
     \
    -filter_complex \
        "[2:v] 
  drawtext=
    fontfile='/Users/theapache64/Documents/projects/auto-motion/lab/komikax.ttf'
    :fontsize=30
    :fontcolor=white
    :x=(w-text_w)/2
    :y=(h-text_h-text_h)/2
    :text='sifarmohammed', 
  drawtext=
    fontfile='/Users/theapache64/Documents/projects/auto-motion/lab/komikax.ttf'
    :fontsize=15
    :fontcolor=gray
    :x=(w-text_w)/2
    :y=(h+text_h)/2
    :text='Oct 02 2024' 
[vi];

[1:a]
    atrim=0.0:3.0,
    afade=
        t=in
        :d=1,
    afade=
        t=out
        :st=2.5,
    asetpts=PTS-STARTPTS
[ai]; 
[0:v]trim=0:6.912,setpts=PTS-STARTPTS[v1]; 
[0:a]atrim=0:6.912,asetpts=PTS-STARTPTS[a1]; 
[0:v]trim=6.912:28.416,setpts=0.25*(PTS-STARTPTS)[tv2]; 
[1:a]atrim=3.0:8.376000000000001,asetpts=PTS-STARTPTS,afade=t=in:d=1,afade=t=out:st=4.376,asetpts=PTS-STARTPTS[ta2]; 
[0:v]
   trim=28.416,
   setpts=PTS-STARTPTS
[v3]; 

[0:a]
   atrim=28.416,
   asetpts=PTS-STARTPTS
[a3];
[2:v] 
  drawtext=fontfile='/Users/theapache64/Documents/projects/auto-motion/lab/komikax.ttf':fontsize=30:fontcolor=white:x=(w-text_w)/2:y=(h-text_h-text_h)/2:text='Thank You!', 
  drawtext=fontfile='/Users/theapache64/Documents/projects/auto-motion/lab/komikax.ttf':fontsize=15:fontcolor=gray:x=(w-text_w)/2:y=(h+text_h)/2:text='sifarmohammed' 
[cv];
[1:a]atrim=8.376000000000001:10.376000000000001,asetpts=PTS-STARTPTS,afade=t=in:d=1,afade=t=out:st=1.8,asetpts=PTS-STARTPTS[ca]; 
[v1][a1][tv2][ta2][v3][a3]concat=
    n=3
    :v=1
    :a=1
    [woiv][woia];[woiv]
    drawtext=
        fontfile='/Users/theapache64/Documents/projects/auto-motion/lab/komikax.ttf'
        :text='sifarmohammed'
        :fontcolor=white
        :fontsize=24
        :box=1
        :boxcolor=black@0.5
        :boxborderw=10
        :x=(w-text_w-10)
        :y=(h-text_h-(text_h/2))
[woivw];
[vi][ai]
[woivw][woia]
[cv][ca]
    concat=n=3:v=1:a=1" \
 "/Users/theapache64/Documents/projects/auto-motion/lab/auto_lion.mp4"