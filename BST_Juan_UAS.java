package bst_juan_uas;

// author @Juan Prima Bangun Priyadi

import java.util.Scanner;

class bstNode{
    bstNode kiri,kanan;
    int data;
       
    //constructor
    public bstNode(int n){
        kiri = null;
        kanan = null;
        data = n;
    }
    
    //fungsi set node kiri
    public void setKiri(bstNode n){
        kiri = n;
    }
    
    //fungsi set node kanan
    public void setKanan(bstNode n){
        kanan = n;
    }
    
    //fungsi untuk ambil dari kiri node
    public bstNode cariKiri(){
        return kiri;
    }
    
    //fungsi untuk ambil dari kanan node
    public bstNode cariKanan(){
        return kanan;
    }
    
    //fungsi untuk set data ke node nya
    public void setData(int d){
        data = d;
    }
    
    //fungsi untuk ambil data dari node
    public int cariData(){
        return data;
    }
  }
    
    class bstTree{
        private bstNode root;
        
        //constructor
        public bstTree(){
            root = null;
        }
        
        //fungsi untuk cek apakah tree kosong
        public boolean kosong(){
            return root == null;
        }
        
        //fungsi untuk insert data
        public void insert(int data){
            root = insert(root, data);
        }
        
        //fungsi untuk insert data secara rekursif
        private bstNode insert(bstNode node, int data){
            
            //jika tree nya kosong, return ke node baru
            if(node == null){
                node = new bstNode(data);
            }else{
                if(data <= node.cariData()){
                    node.kiri = insert(node.kiri, data);
                }else{
                    node.kanan = insert(node.kanan, data);
                }
            }
            return node;
        }
        
        //fungsi untuk delete suatu node
        public void delete(int k){
             if (kosong())
             System.out.println("TREE KOSONG");
         else if (search(k) == false)
             System.out.println("DATA "+ k +" TIDAK DITEMUKAN");
         else{
                root = delete(root, k);
                System.out.println("DATA "+k+" BERHASIL DIHAPUS");
            }
        }
        
        private bstNode delete(bstNode root, int k){
            bstNode p,p2,n;
            if(root.cariData() == k){
                bstNode lr,rr;
                lr = root.cariKiri();
                rr = root.cariKanan();
                if(lr == null && rr == null)
                    return null;
                else if(lr == null){
                    p = rr;
                    return p;
                }else if(rr == null){
                    p = lr;
                    return p;
                }else{
                    p2 = lr;
                    p = lr;
                    while(p.cariKiri() != null)
                        p = p.cariKiri();
                    p.setKiri(lr);
                    return p2;
                }   
            }
            if(k < root.cariData()){
                n = delete(root.cariKiri(), k);
                root.setKiri(n);
            }else{
                n = delete(root.cariKanan(), k);
                root.setKanan(n);
            } 
            return root;
        }
        
        //fungsi untuk mencari sebuah data atau elemen
        public boolean search(int val){
            return search(root, val);
        }
        
        //fungsi untuk mencari data secara rekursif
        private boolean search(bstNode r, int val){
            boolean ketemu = false;
            while (r != null && !ketemu){
                int rval = r.cariData();
                if(val < rval){
                    r = r.cariKiri();
                    
                }else if( val > rval){
                    r = r.cariKanan();
                    
                }else{
                    ketemu = true;
                    break;
                }
                ketemu = search(r, val);
            }
            
            return ketemu;
        }
        
        //fungsi untuk menampilkan status search 
        public void searchFound(int k){
             if (kosong())
             System.out.println("TREE KOSONG");
         else if (search(k) == false)
             System.out.println("Hasil Pencarian : DATA TIDAK DITEMUKAN");
         else{
             System.out.println("Hasil Pencarian : DATA DITEMUKAN");
            }
        }
        
        //fungsi menampilkan tree secara InOrder
        public void inorder(){
            inorder(root);
        }
        private void inorder(bstNode r){
            if (r!= null){
                inorder(r.cariKiri());
                System.out.print(r.cariData() +" -> ");
                inorder(r.cariKanan());
            }
        }
        
        //fungsi menampilkan tree secara PreOrder
        public void preorder(){
            preorder(root);
        }
        private void preorder(bstNode r){
            if (r!= null){
             System.out.print(r.cariData() +" -> ");
             preorder(r.cariKiri());             
             preorder(r.cariKanan());
            }
        }
        
        //fungsi menampilkan tree secara PostOrder
        public void postorder(){
            postorder(root);
        }
        private void postorder(bstNode r){
            if (r != null){
             postorder(r.cariKiri());             
             postorder(r.cariKanan());
             System.out.print(r.cariData() +" -> ");
            }
        } 
        
        //fungsi untuk menampilkan nilai terbesar
        public Integer findMaxValue() {
        return maxValue(this.root);
    }
        
        private Integer maxValue(bstNode node) {
        if(node.cariKanan() != null) {
            return maxValue(node.cariKanan());
        }
        return node.cariData();
    }
        
        //fungsi untuk menampilkan nilai terkecil     
        public Integer findMinValue() {
        return minValue(this.root);
    }
 
        private Integer minValue(bstNode node) {
        if(node.cariKiri() != null) {
            return minValue(node.cariKiri());
        }
        return node.cariData();
    }

        //fungsi menghapus seluruh isi tree
        public void deleteTree(){
            deleteTree(root);
            root = null;
            System.out.println("SELURUH ISI BST TELAH DIHAPUS");
        }
        
        private bstNode deleteTree(bstNode root) {
		if(null == root) {
			return null;
		}
                deleteTree(root.cariKiri());
                deleteTree(root.cariKanan());
		root = null;
		return root;
	}
        
    }


public class BST_Juan_UAS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //membuat object bst nya
        bstTree bst = new bstTree();
        
        
        System.out.println("Binary Search Tree");
        String menu;
        
        do{
            System.out.println("BST - UAS PSDA");
            System.out.println("Menu : ");
            System.out.println("1. INSERT BST");
            System.out.println("2. DELETE BST");
            System.out.println("3. SEARCH BST");
            System.out.println("4. INORDER TRAVERSAL");
            System.out.println("5. PREORDER TRAVERSAL");
            System.out.println("6. POSTORDER TRAVERSAL");
            System.out.println("7. NILAI BST TERKECIL");
            System.out.println("8. NILAI BST TERBESAR");
            System.out.println("9. CLEAR BST");
            System.out.print("Masukkan Pilihan : ");
            int pilih = scan.nextInt();
            System.out.println("==================================");
            
            switch (pilih){
                case 1 :
                    System.out.println("Masukkan angka yang ingin ditambahkan : ");
                    bst.insert( scan.nextInt() );
                    System.out.println("");
                    break;
                   
                case 2 :
                    System.out.println("Masukkan angka yang ingin dihapus : ");
                    bst.delete(scan.nextInt());
                    break;
               
                case 3 :
                    System.out.println("Masukkan angka yang ingin dicari : ");
                    bst.searchFound(scan.nextInt());                   
                    break; 

                case 4 :
                    System.out.println("Urutan dalam InOrder : ");
                    bst.inorder();
                    System.out.println("");
                    break;
                    
                case 5 :
                    System.out.println("Urutan dalam PreOrder : ");
                    bst.preorder();
                    System.out.println("");
                    break;
                    
                case 6 :
                    System.out.println("Urutan dalam PostOrder : ");
                    bst.postorder();
                    System.out.println("");
                    break;
                    
                case 7 :
                    System.out.println("Nilai yang terkecil adalah " + bst.findMinValue());
                    break;
                    
                case 8 :
                    System.out.println("Nilai yang terbesar adalah " + bst.findMaxValue());
                    break;
                    
                case 9 : 
                    bst.deleteTree();
                    System.out.println("");
                    break;
                    
                default :
                    System.out.println("Pilihan Angka Salah! ");
                    break;
            }
            System.out.println("Apakah anda ingin menggunakan program lagi? (y / n) : ");
            menu = scan.next();
            System.out.println("");
        }while (!menu.equals("n"));
        System.out.println("Terima kasih telah menggunakan program ini");
        
    }
}
