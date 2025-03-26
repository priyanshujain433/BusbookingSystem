        function passanger() {
            var p = document.getElementById("ticketcount").value;
            var a = document.getElementById("passanger1name");
            var c = document.getElementById("passanger2name");
            var e = document.getElementById("passanger3name");
            var b = document.getElementById("passanger1number");
            var d = document.getElementById("passanger2number");
            var f = document.getElementById("passanger3number");
            var r = document.getElementById("fare").value;
            var s = document.getElementById("totalfare");
            var btn = document.getElementById("btn");
            var n = document.getElementById("noOfTickets");
            console.log(s);
            if (p==1) {
            	var t1 = p*r;
            	console.log(t1);
            	s.value = t1;
            	btn.style.display = "block";
            	n.style.display = "block";
            	a.required = true;
            	a.style.display = "block";
                b.style.display = "block";
                b.required = true;
                c.style.display = "none";
                d.style.display = "none";
                e.style.display = "none";
                f.style.display = "none";
            } else if(p==2) {
            	var t3 = p*r;
            	s.value = t3;
            	n.style.display = "block";
            	btn.style.display = "block";
            	b.required = true;
            	a.style.display = "block";
            	b.required = true;
                b.style.display = "block";
                c.required = true;
                c.style.display = "block";
                d.required = true;
                d.style.display = "block";
                e.style.display = "none";
                f.style.display = "none";
            }else if(p==3){
            	var t3 = p*r;
            	s.value = t3;
            	n.style.display = "block";
            	btn.style.display = "block";
            	b.required = true;
            	a.style.display = "block";
            	b.required = true;
                b.style.display = "block";
                c.required = true;
                c.style.display = "block";
                d.required = true;
                d.style.display = "block";
                e.required = true;
                e.style.display = "none";
                f.required = true;
                f.style.display = "none";
            }
            else{
				n.style.display = "none";
            	btn.style.display = "none";
            	a.style.display = "none";
                b.style.display = "none";
                c.style.display = "none";
                d.style.display = "none";
                e.style.display = "none";
                f.style.display = "none";
                
            }
    }