import java.util.*;
public class FIFOPageReplacement {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 
 System.out.print("Enter the number of frames: ");
 int numberOfFrames = scanner.nextInt();

 System.out.print("Enter the number of pages: ");
 int numberOfPages = scanner.nextInt();

 System.out.print("Enter the page reference string (space-separated): ");
 int[] pageReferenceString = new int[numberOfPages];
 for (int i = 0; i < numberOfPages; i++) {
 pageReferenceString[i] = scanner.nextInt();
 }

 int[] frames = new int[numberOfFrames];
 Arrays.fill(frames, -1);

 int pageFaults = 0;
 int currentIndex = 0;

 for (int page : pageReferenceString) 
 {
 boolean pageHit = false;
 for (int frame : frames) 
 {
 if (frame == page) 
 {
 pageHit = true;
 break;
 }
 }

 if (!pageHit) 
 {
 frames[currentIndex] = page;
 currentIndex = (currentIndex + 1) % numberOfFrames;
 pageFaults++;
 }

 System.out.print("Frames: ");
 for (int frame : frames) 
 {
 System.out.print(frame + " ");
 }
 System.out.println();
 }
 System.out.println("Total Page Faults: " + pageFaults);
 scanner.close();
 }
}
