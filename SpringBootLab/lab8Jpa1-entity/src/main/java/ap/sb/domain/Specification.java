package ap.sb.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Embeddable
public class Specification implements Serializable{
	
	int height;
	int thickness;
	int width;

}
