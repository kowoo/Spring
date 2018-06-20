package robot;

import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class Transformer extends Robot {
	
//	@Autowired
//	public Transformer(@Qualifier("gun")Attackable attack, @Qualifier("run")Moveable move) {
//		this.name = "트랜스포머";
//		this.attack = attack;
//		this.move = move;
//	}
	
	public void setProperties(Map<String, Object> prop) {
		Attackable attack = (Attackable)prop.get("gun");
		Moveable move = (Moveable)prop.get("fly");
		this.name = "트랜스포머";
		this.attack = attack;
		this.move = move;
	}
}
