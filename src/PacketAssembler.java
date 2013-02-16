import java.util.ArrayList;
import java.util.Scanner;


public class PacketAssembler
{
	ArrayList<Packet> packetList;
	ArrayList<String> messageList;
	
	public PacketAssembler()
	{
		this.packetList = new ArrayList<Packet>();
		this.messageList = new ArrayList<String>();
	}
	
	public Packet addPacket(int messageIndex, Packet packet)
	{
		Packet temp = null;
		
		if(!this.containsPacket(packet))
		{
			this.packetList.add(packet);
			temp = packet;
		}
		
		return temp;
	}
	
	public int readPacket(Scanner inFile)
	{
		int value = 0;
		Packet temp = null;
		
		if (this.getSize()==0)
		{
			while(inFile.hasNextLine())
			{
				temp = new Packet();
				temp = temp.readPacket(new Scanner(inFile.nextLine()));
				this.addPacket(this.getMessageIndex(temp), temp);
				this.messageList.add(temp.toString());
			}
		}
		
		return value;
	}
	
	private Integer getMessageIndex(Packet packet)
	{
		Integer index = 0;

		for (int i = 0; i < this.packetList.size(); i++)
		{
			if (this.packetList.get(i).equals(packet))
			{
				index = i;
			}
		}

		return index;
	}

	private boolean containsPacket(Packet packet)
	{
		boolean isInThere = false;
		
		for (int i = 0; i < this.packetList.size(); i++)
		{
			if(this.packetList.get(i).equals(packet))
			{
				isInThere = true;
				break;
			}
		}
		
		return isInThere;
		
	}
	
	public String dumpMessage(int messageID)
	{
		String message = "";
		
		for (int i = 0; i < this.packetList.size(); i++)
		{
			if(this.packetList.get(i).getMessageID()==messageID)
			{
				message += this.messageList.get(i).toString();
			}
		}
		
		return message;
	}
	
	private int getSize()
	{
		return this.packetList.size();
	}
	
	
}
